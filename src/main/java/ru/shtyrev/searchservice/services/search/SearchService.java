package ru.shtyrev.searchservice.services.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shtyrev.searchservice.documents.ESProject;
import ru.tasktrade.monolithservice.project.dtos.ProjectDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {
    private final ElasticsearchClient elasticsearchClient;

    @Autowired
    public SearchService(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public List<ProjectDTO> search(String searchText) throws IOException {
        Query query = MultiMatchQuery.of(q -> q
                .query(searchText)
                .type(TextQueryType.BestFields)
                .operator(Operator.Or)
                .minimumShouldMatch("2")
                .fuzziness("AUTO")
                .boost(2.0F)
                .prefixLength(1)
        )._toQuery();

        SearchResponse<ESProject> searchResponse = elasticsearchClient.search(s -> s
                        .index("projects")
                        .query(q -> q
                                .bool(b -> b.
                                        must(query)
                                ))
                , ESProject.class);

        return getProducts(searchResponse);
    }

    @NotNull
    public static List<ProjectDTO> getProducts(SearchResponse<ESProject> searchResponse) {
        List<Hit<ESProject>> listOfHits= searchResponse.hits().hits();
        List<ProjectDTO> listOfProducts  = new ArrayList<>();
        for(Hit<ESProject> hit : listOfHits){
            assert hit.source() != null;
            listOfProducts.add(hit.source().getProject());
        }
        return listOfProducts;
    }
}
