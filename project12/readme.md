# Project 12

Copy 'project12' into your IdeaProjects folder. 
Create an application named 'PeopleTest'.

The application is to read the data found in 'people.data', save the information, sort the data into alphabetical order, and print the information for each person.

The first character of each line in people.data defines the type of person the line represents.   
A 'p' denotes professor, a 'u' denotes undergraduate, an 'm' denotes masters degree student, and a 'd' denotes doctoral degree student.

## Data line descriptions:
- professor: 
    - soc-sec-number, name, discipline
- undergraduate: soc-sec-number, name, student-number, major
- masters student: soc-sec-number, name, student-number, undergrad-institution, thesis title
- doctoral student: soc-sec-number, name, student-number, undergrad-institution, dissertation title

##Additional question:
- Explain how the sort process knew to order the objects in the ArrayList alphabetically.

## Results:
- `Comparable` interface implementation allows for the use of `Collections.sort();`
- [java.util.Collections](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html)
