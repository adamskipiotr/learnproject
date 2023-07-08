package com.pada.learnproject.example;

import static com.pada.learnproject.example.constant.ExampleEntityMother.createDefaultTestExampleEntity;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createSecondTestExampleEntity;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createThirdTestExampleEntity;
import static com.pada.learnproject.example.constant.ManyToManyEntityMother.createDefaultTestManyToManyEntity;
import static com.pada.learnproject.example.constant.ManyToOneEntityMother.createDefaultTestManyToOneEntity;
import static com.pada.learnproject.example.constant.OneToOneEntityMother.createDefaultTestOneToOneEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.domain.ManyToManyEntity;
import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.domain.OneToOneEntity;
import com.pada.learnproject.example.repository.ExampleEntityRepository;
import com.pada.learnproject.example.repository.ManyToManyRepository;
import com.pada.learnproject.example.repository.ManyToOneRepository;
import com.pada.learnproject.example.repository.OneToOneRepository;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class ExampleBaseIT  extends LearnprojectApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    protected ExampleEntity exampleEntity;
    protected OneToOneEntity oneToOneEntity;
    protected ManyToOneEntity manyToOneEntity;
    protected ManyToManyEntity manyToManyEntity;
    @Autowired
    private ExampleEntityRepository exampleEntityRepository;
    @Autowired
    private OneToOneRepository oneToOneRepository;
    @Autowired
    private ManyToOneRepository manyToOneRepository;
    @Autowired
    private ManyToManyRepository manyToManyRepository;

    @BeforeEach
    @Transactional
    public void setUpTestData() {
        insertDefaultExampleEntity();
        insertManyToOneExampleEntity();
        insertManyToManyExampleEntity();

        exampleEntityRepository.saveAndFlush(createSecondTestExampleEntity());
        exampleEntityRepository.saveAndFlush(createThirdTestExampleEntity());
    }

    private void insertDefaultExampleEntity() {
        exampleEntity = createDefaultTestExampleEntity();
        exampleEntity.setOneToOneEntity(createDefaultTestOneToOneEntity());
        exampleEntity.getOneToOneEntity().setExampleEntity(exampleEntity);
        exampleEntity = exampleEntityRepository.saveAndFlush(exampleEntity);
    }

    private void insertManyToOneExampleEntity() {
        manyToOneEntity = createDefaultTestManyToOneEntity();
        manyToOneEntity = manyToOneRepository.save(manyToOneEntity);

        exampleEntity.addManyToOneEntity(manyToOneEntity);
        exampleEntityRepository.save(exampleEntity);
    }

        private void insertManyToManyExampleEntity() {
            manyToManyEntity = createDefaultTestManyToManyEntity();
            manyToManyEntity = manyToManyRepository.saveAndFlush(manyToManyEntity);

            exampleEntity.setManyToManyEntitySet(new TreeSet<>(Set.of(manyToManyEntity)));
            exampleEntity = exampleEntityRepository.save(exampleEntity);
        }


    @AfterEach
    public void deleteTestData() {
        exampleEntityRepository.deleteAll();
    }
}
