//package com.example.sqlreports.countryReport;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.jdbc.Sql;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJdbcTest
//@ActiveProfiles("test")
//@Sql(scripts = {"/test-schema.sql", "/test-data.sql"})
//class CountryRepositoryTest {
//
//    @Autowired
//    private CountryRepository countryRepository;
//
//    @Test
//    void testFindAllCountriesByWorldOrderedByPopulation() {
//        List<CountryEntity> countries = countryRepository.findAllCountriesByWorldOrderedByPopulation();
//
//        assertEquals(5, countries.size());
//        assertEquals("China", countries.get(0).getName());
//        assertEquals("United States", countries.get(1).getName());
//        assertEquals("Brazil", countries.get(2).getName());
//    }
//
//    @Test
//    void testFindCountriesByContinentOrderedByPopulation() {
//        List<CountryEntity> countries = countryRepository.findCountriesByContinentOrderedByPopulation("North America");
//
//        assertEquals(3, countries.size());
//        assertEquals("United States", countries.get(0).getName());
//        assertEquals("Mexico", countries.get(1).getName());
//        assertEquals("Canada", countries.get(2).getName());
//    }
//
//    @Test
//    void testFindCountriesByRegionOrderedByPopulation() {
//        List<CountryEntity> countries = countryRepository.findCountriesByRegionOrderedByPopulation("Americas");
//
//        assertEquals(4, countries.size());
//        assertEquals("United States", countries.get(0).getName());
//        assertEquals("Brazil", countries.get(1).getName());
//        assertEquals("Mexico", countries.get(2).getName());
//    }
//
//    @Test
//    void testFindAllCountriesWithLimitByWorldOrderedByPopulation() {
//        List<CountryEntity> countries = countryRepository.findAllCountriesWithLimitByWorldOrderedByPopulation(3);
//
//        assertEquals(3, countries.size());
//        assertEquals("China", countries.get(0).getName());
//        assertEquals("United States", countries.get(1).getName());
//    }
//
//    @Test
//    void testFindCountriesWithLimitByContinentOrderedByPopulation() {
//        List<CountryEntity> countries = countryRepository.findCountriesWithLimitByContinentOrderedByPopulation("North America", 2);
//
//        assertEquals(2, countries.size());
//        assertEquals("United States", countries.get(0).getName());
//        assertEquals("Mexico", countries.get(1).getName());
//    }
//
//    @Test
//    void testFindCountriesWithLimitByRegionOrderedByPopulation() {
//        List<CountryEntity> countries = countryRepository.findCountriesWithLimitByRegionOrderedByPopulation("Americas", 2);
//
//        assertEquals(2, countries.size());
//        assertEquals("United States", countries.get(0).getName());
//        assertEquals("Brazil", countries.get(1).getName());
//    }
//}
