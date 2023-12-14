package ru.shtyrev.searchservice.services.impl;

import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shtyrev.searchservice.documents.ESProject;
import ru.shtyrev.searchservice.exceptions.ESProjectNotFound;
import ru.shtyrev.searchservice.repositories.ESProjectRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.*;


class ESProjectServiceImplTest {

}