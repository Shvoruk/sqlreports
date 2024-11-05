//package com.example.sqlreports.repository;
//
//import org.springframework.data.jdbc.repository.query.Query;
//import org.springframework.data.repository.CrudRepository;
//import java.util.List;
//import com.sqlreports.model.Country; // waiting on vlad
//
//
//
//public interface CountryRepository extends CrudRepository<Country, String> {
//
//    @Query("SELECT * FROM country ORDER BY population DESC")
//    List<Country> findAllCountriesOrderedByPopulation();
//
//    @Query("SELECT * FROM country WHERE continent = :continent ORDER BY population DESC")
//    List<Country> findCountriesByContinentOrderedByPopulation(String continent);
//
//    @Query("SELECT * FROM country WHERE region = :region ORDER BY population DESC")
//    List<Country> findCountriesByRegionOrderedByPopulation(String region);
//
//    @Query("SELECT * FROM country ORDER BY population DESC LIMIT :limit")
//    List<Country> findTopNCountries(int limit);
//
//
//    // Temporary Country entity class
//    public static class Country {
//        private String id;
//        private String name;
//        private int population;
//
//        // Getters and Setters
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getPopulation() {
//            return population;
//        }
//
//        public void setPopulation(int population) {
//            this.population = population;
//        }
//    }
//}
//
