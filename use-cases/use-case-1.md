# USE CASE: 1 Produce a Report on All the Countries in a Continent Organised by Largest Population to Smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *demographic researcher* I want *to produce a report on all the countries in a specific continent organised by largest population to smallest* so that *I can analyze population distribution within continents.*

### Scope

Continent-level country data.

### Level

Primary task.

### Preconditions

Database contains current country population data categorized by continent. User has access to the reporting system.

### Success End Condition

A report is generated listing all countries in the specified continent, sorted by population in descending order.

### Failed End Condition

No report is produced or the report is incomplete.

### Primary Actor

Demographic Researcher.

### Trigger

Researcher initiates a request for a continent-specific country population report.

## MAIN SUCCESS SCENARIO

1. Researcher selects the option to generate a continent-specific country population report.
2. System prompts for the continent name.
3. Researcher enters the name of the continent.
4. System validates the continent name.
5. System queries the database for all countries in the specified continent.
6. System sorts the countries by population in descending order.
7. System generates a report with the sorted country list.
8. System presents the report to the researcher.

## EXTENSIONS

4. **Continent name is invalid**:
    1. System informs the researcher that the entered continent name is not recognized.
    2. Researcher is prompted to enter a valid continent name.
    3. Use case resumes from step 3.
5. **No countries found for the specified continent**:
    1. System informs the researcher that no country data is available for the specified continent.
    2. Use case ends.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

## REQUIRED REPORT COLUMNS

1. Country Code
2. Country Name
3. Continent
4. Region
5. Population
6. Capital
