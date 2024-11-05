# USE CASE: 4 Produce a Population Report for a Continent

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *population analyst* I want *to produce a report on the population of people, people living in cities, and people not living in cities in a specific continent* so that *I can analyze urbanization trends across the continent.*

### Scope

Continent-level population data.

### Level

Primary task.

### Preconditions

Database contains current population data for countries and cities, categorized by continent. User has access to the reporting system.

### Success End Condition

A report is generated providing the total population, urban population, and rural population for the specified continent, including percentages.

### Failed End Condition

No report is produced or the report contains incomplete population data.

### Primary Actor

Population Analyst.

### Trigger

Analyst initiates a request for a continent-specific population report.

## MAIN SUCCESS SCENARIO

1. Analyst selects the option to generate a population report for a specific continent.
2. System prompts for the continent name.
3. Analyst enters the name of the continent.
4. System validates the continent name.
5. System queries the database for total population data of the continent.
6. System queries the database for urban population data of the continent.
7. System calculates the rural population (total - urban).
8. System calculates percentages for urban and rural populations.
9. System generates a report with the population data and percentages.
10. System presents the report to the analyst.

## EXTENSIONS

4. **Continent name is invalid**:
    1. System informs the analyst that the entered continent name is not recognized.
    2. Analyst is prompted to enter a valid continent name.
    3. Use case resumes from step 3.
5. **No population data found for the specified continent**:
    1. System informs the analyst that no population data is available for the specified continent.
    2. Use case ends.
6. **Urban population data is missing**:
    1. System skips urban/rural calculations.
    2. System generates a report with only total population data.
    3. System includes a note in the report indicating that urban/rural data is unavailable.
    4. Use case continues from step 10.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

## REQUIRED REPORT INFORMATION

1. Continent Name
2. Total Population
3. Urban Population (number and percentage)
4. Rural Population (number and percentage)
