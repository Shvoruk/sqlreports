# USE CASE: 3 Produce a Report on All the Capital Cities in a Region Organised by Largest to Smallest Population

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *government advisor* I want *to produce a report on all the capital cities in a specific region organised by largest to smallest population* so that *I can analyze the distribution of administrative centers in the region.*

### Scope

Region-level capital city data.

### Level

Primary task.

### Preconditions

Database contains current capital city population data categorized by region. User has access to the reporting system.

### Success End Condition

A report is generated listing all capital cities in the specified region, sorted by population in descending order.

### Failed End Condition

No report is produced or the report is incomplete.

### Primary Actor

Government Advisor.

### Trigger

Advisor initiates a request for a region-specific capital cities population report.

## MAIN SUCCESS SCENARIO

1. Advisor selects the option to generate a region-specific capital cities population report.
2. System prompts for the region name.
3. Advisor enters the name of the region.
4. System validates the region name.
5. System queries the database for all capital cities in the specified region.
6. System sorts the capital cities by population in descending order.
7. System generates a report with the sorted capital city list.
8. System presents the report to the advisor.

## EXTENSIONS

4. **Region name is invalid**:
    1. System informs the advisor that the entered region name is not recognized.
    2. Advisor is prompted to enter a valid region name.
    3. Use case resumes from step 3.
5. **No capital cities found for the specified region**:
    1. System informs the advisor that no capital city data is available for the specified region.
    2. Use case ends.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

## REQUIRED REPORT COLUMNS

1. City Name
2. Country
3. Population
