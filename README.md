
# **Population Information Reports**

![Master Build Status](https://img.shields.io/github/actions/workflow/status/Shvoruk/sqlreports/master.yml?branch=master)  
![Develop Branch Status](https://img.shields.io/github/actions/workflow/status/Shvoruk/sqlreports/develop.yml?branch=develop)  
[![LICENSE](https://img.shields.io/github/license/Shvoruk/sqlreports.svg?style=flat-square)](https://github.com/Shvoruk/sqlreports/blob/master/LICENSE)  
[![Releases](https://img.shields.io/github/release/Shvoruk/sqlreports/all.svg?include_prereleases&style=flat-square)](https://github.com/Shvoruk/sqlreports/releases)  
[![Code Coverage](https://codecov.io/github/Shvoruk/sqlreports/branch/master/graph/badge.svg?token=ob1cArXXM6)](https://app.codecov.io/github/Shvoruk/sqlreports)

This repository provides system to generate detailed population reports based on data from database. The project enables easy access to information about countries, cities, and languages, including their populations and demographics.

---

## **Live Application**

The system is available for use at:  
[**Population Reports Application**](https://population-reports-bhehbbbsd5fdche9.ukwest-01.azurewebsites.net/)

---

## **Features**

The system generates the following types of reports:

### Country Report

- All the countries in the world organised by largest population to smallest.
- All the countries in a continent organised by largest population to smallest.
- All the countries in a region organised by largest population to smallest.
- The top `N` populated countries in the world where `N` is provided by the user.
- The top `N` populated countries in a continent where `N` is provided by the user.
- The top `N` populated countries in a region where `N` is provided by the user.

| **Field**       | **Description**       |
|------------------|-----------------------|
| `Code`          | ISO country code      |
| `Name`          | Country name          |
| `Continent`     | Continent name        |
| `Region`        | Geographical region   |
| `Population`    | Total population      |
| `Capital`       | Capital city name     |

### City Report

- All the cities in the world organised by largest population to smallest.
- All the cities in a continent organised by largest population to smallest.
- All the cities in a region organised by largest population to smallest.
- All the cities in a country organised by largest population to smallest.
- All the cities in a district organised by largest population to smallest.
- The top `N` populated cities in the world where `N` is provided by the user.
- The top `N` populated cities in a continent where `N` is provided by the user.
- The top `N` populated cities in a region where `N` is provided by the user.
- The top `N` populated cities in a country where `N` is provided by the user.
- The top `N` populated cities in a district where `N` is provided by the user.

| **Field**       | **Description**       |
|------------------|-----------------------|
| `Name`          | City name             |
| `Country`       | Country name          |
| `District`      | District name         |
| `Population`    | City population       |

### Capital City Report

- All the capital cities in the world organised by largest population to smallest.
- All the capital cities in a continent organised by largest population to smallest.
- All the capital cities in a region organised by largest to smallest.
- The top `N` populated capital cities in the world  where `N` is provided by the user.
- The top `N` populated capital cities in a continent where `N` is provided by the user.
- The top `N` populated capital cities in a region where `N` is provided by the user.

| **Field**       | **Description**       |
|------------------|-----------------------|
| `Name`          | Capital city name     |
| `Country`       | Country name          |
| `Population`    | Population of capital |

### Population Report

- The population of people, people living in cities, and people not living in cities in each continent.
- The population of people, people living in cities, and people not living in cities in each region.
- The population of people, people living in cities, and people not living in cities in each country.

| **Field**                     | **Description**                                   |
|--------------------------------|-------------------------------------------------|
| `Continent/Region/Country`    | Name of the entity                               |
| `Total Population`            | Total population                                |
| `Population in Cities`        | Number and percentage living in cities          |
| `Population Outside Cities`   | Number and percentage not living in cities      |


Additionally, the following information is accessible:

- The population of the world.
- The population of a continent.
- The population of a region.
- The population of a country.
- The population of a district.
- The population of a city.

Finally, the number of people who speak the following languages from greatest number to smallest, including the percentage of the world population is accessible:

- Chinese.
- English.
- Hindi.
- Spanish.
- Arabic.

---

### **Setup**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Shvoruk/sqlreports.git
   cd sqlreports
   ```

2. **Run the Application**:
   Use Docker Compose to start the application:
   ```bash
   docker-compose up
   ```

3. **Access the Application**:
   Once the application is running, open your browser and navigate to:
   [http://localhost:8080](http://localhost:8080)

---

## **Contributing**

Contributions are welcome! To add a new report or improve existing scripts:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/new-report
   ```
3. Add your changes and commit:
   ```bash
   git commit -m "Add new report for XYZ"
   ```
4. Push your branch and create a pull request.

---

## **Contact**

For any questions or feedback, please create an issue in the repository.
