## Use Case Diagram

![Use Case Diagram](use-cases/use_case_diagram.png)

## Use Cases

### 1. Generate Country Population Report
- **Primary Actor**: Data Analyst
- **Goal**: Retrieve a list of countries organized by population size based on various criteria.
- **Trigger**: The analyst selects a report type (e.g., "Countries in the World by Population").
- **Main Flow**:
  1. The analyst selects the report criteria (e.g., by continent, by region, top N countries).
  2. The system queries the database for the countries based on the selected criteria.
  3. The system sorts the countries by population in descending order.
  4. The report is generated and displayed or exported.
- **Postconditions**: Report is generated and accessible to the analyst.

### 2. Generate City Population Report
- **Primary Actor**: Data Analyst
- **Goal**: Retrieve a list of cities organized by population size, with options to filter by continent, country, district, or world.
- **Trigger**: The analyst selects a city report type.
- **Main Flow**:
  1. The analyst chooses the report filter (e.g., by country, by district, top N cities).
  2. The system retrieves city data based on the selected filter.
  3. The system organizes cities by population in descending order.
  4. The report is generated and presented.
- **Postconditions**: City population report is available to the analyst.

### 3. Generate Capital City Population Report
- **Primary Actor**: Data Analyst
- **Goal**: Produce a list of capital cities ordered by population size, with options to filter by geographic levels.
- **Trigger**: Analyst requests a capital city report.
- **Main Flow**:
  1. The analyst selects a filter (e.g., by continent, by region, top N capitals).
  2. The system queries the database for matching capital cities.
  3. The system sorts the cities by population.
  4. The report is generated and accessible.
- **Postconditions**: Capital city report is completed and available.

### 4. Generate Population Distribution Report
- **Primary Actor**: Data Analyst
- **Goal**: Obtain population data showing total, urban, and rural populations for each continent, region, or country.
- **Trigger**: Analyst initiates a population distribution report.
- **Main Flow**:
  1. The analyst selects the geographic level for the report (e.g., continent, region, country).
  2. The system retrieves population data, calculating urban and rural percentages.
  3. Data is organized and summarized by geographic level.
  4. Report is generated for the analyst.
- **Postconditions**: Population distribution report is accessible.

### 5. Retrieve World Population
- **Primary Actor**: Data Analyst
- **Goal**: Obtain the total population of the world.
- **Trigger**: Analyst selects the "World Population" report.
- **Main Flow**:
  1. The analyst requests total world population data.
  2. The system retrieves and aggregates all countries’ populations.
  3. The total population is displayed.
- **Postconditions**: Total world population is displayed.

### 6. Retrieve Population by Geographic Level
- **Primary Actor**: Data Analyst
- **Goal**: Get population data for a specific continent, region, country, or district.
- **Trigger**: Analyst requests population data for a specific level.
- **Main Flow**:
  1. The analyst specifies the geographic level (continent, region, country, or district).
  2. The system retrieves and aggregates population data.
  3. Population data is presented.
- **Postconditions**: Population data for the specified level is displayed.

### 7. Generate Language Speaker Report
- **Primary Actor**: Data Analyst
- **Goal**: Generate a report listing the number of speakers and percentage of the world population for each specified language (e.g., Chinese, English).
- **Trigger**: Analyst initiates a language report request.
- **Main Flow**:
  1. The analyst selects the language report type.
  2. The system retrieves data on speakers for specified languages.
  3. The system calculates the percentage of world population for each language.
  4. The report is generated and presented.
- **Postconditions**: Language speaker report is completed and accessible.

### 8. Run Tests with GitHub Actions
- **Primary Actor**: Developer
- **Goal**: Run all unit and integration tests automatically on GitHub upon code updates.
- **Trigger**: Developer pushes code or creates a pull request.
- **Main Flow**:
  1. Developer pushes code to the repository.
  2. GitHub Actions workflow runs all specified tests.
  3. The system reports test results, indicating any failures or errors.
- **Postconditions**: Test results are displayed on GitHub; failures prompt further investigation.


