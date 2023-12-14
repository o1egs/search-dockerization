package ru.shtyrev.searchservice.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.shtyrev.searchservice.documents.ESProject;

import java.util.List;
import java.util.Optional;

public interface ESProjectRepository extends ElasticsearchRepository<ESProject, String>, PagingAndSortingRepository<ESProject, String> {
    Optional<ESProject> findByProject_Id(Long id);

    @Query(value = "{\"bool\": {\"must\": [{\"multi_match\": {\"query\": \"?0\", \"type\": \"best_fields\", \"operator\": \"or\", \"minimum_should_match\": 1, \"fuzziness\": \"AUTO\", \"boost\": 2.0, \"prefix_length\": 1}}]}}")
    List<ESProject> search(@Param("searchText") String searchText, Pageable pageable);
}
