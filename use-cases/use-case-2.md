# USE CASE: 2 Produce a Report on the Top N Populated Cities in a Country

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *urban planner* I want *to produce a report on the top N populated cities in a specific country where N is provided by the user* so that *I can analyze urban population concentrations within countries.*

### Scope

Country-level city data.

### Level

Primary task.

### Preconditions

Database contains current city population data categorized by country. User has access to the reporting system.

### Success End Condition

A report is generated listing the top N populated cities in the specified country, sorted by population in descending order.

### Failed End Condition

No report is produced or the report contains fewer than N cities.

### Primary Actor

Urban Planner.

### Trigger

Planner initiates a request for a country-specific top N cities report.

## MAIN SUCCESS SCENARIO

1. Planner selects the option to generate a top N cities report for a specific country.
2. System prompts for the country name and the value of N.
3. Planner enters the country name and N.
4. System validates the country name and N.
5. System queries the database for cities in the specified country.
6. System sorts the cities by population in descending order.
7. System selects the top N cities from the sorted list.
8. System generates a report with the selected cities.
9. System presents the report to the planner.

## EXTENSIONS

4a. **Country name is invalid**:
    1. System informs the planner that the entered country name is not recognized.
    2. Planner is prompted to enter a valid country name.
    3. Use case resumes from step 3.

4b. **N is not a positive integer**:
    1. System informs the planner that N must be a positive integer.
    2. Planner is prompted to enter a valid value for N.
    3. Use case resumes from step 3.

5. **Fewer than N cities found for the specified country**:
    1. System generates a report with all available cities, sorted by population.
    2. System includes a note in the report indicating that fewer than N cities were found.
    3. Use case continues from step 9.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

## REQUIRED REPORT COLUMNS

1. City Name
2. Country
3. District
4. Population
