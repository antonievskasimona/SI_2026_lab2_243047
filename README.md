# SI_2026_lab2_243047
## Simona Antonievska 243047
### Control Flow Graph
searchBookByTitle
<img width="728" height="851" alt="searchBookCFG drawio" src="https://github.com/user-attachments/assets/7c8646e0-f2ad-4912-919d-9ebdbe9d4c55" /> 
### borrowBook
 <img width="671" height="911" alt="borrowBook drawio" src="https://github.com/user-attachments/assets/47bb374b-41d5-4076-b77d-3db9b5f95490" />
## Цикломатска комплексност
Цикломатската комплексност за searchBookByTitle е 5.
Таа е пресметана со броење на 4 decision nodes (2 if услови, 1 for loop и 1 if проверка за празен резултат) и додавање 1 според формулата P+1.

Цикломатската комплексност за borrowBook е 5.
Пресметката е направена со броење на 4 decision nodes (еден if со OR услов, една for-јамка и две if проверки во циклусот) и примена на формулата P+1.

## Тест случаи според критериумот Every statement
| Линија/Statement | Test 1–Empty title | Test 2–Book exists | Test 3–Book does not exist |
|---|---|---|---|
| if(title.isEmpty()) | * |  |  |
| throw new IllegalArgumentException | * |  |  |
| List<Book> results = new ArrayList<Book>() |  | * | * |
| for (Book book : books) |  | * | * |
| if(book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) |  | * | * |
| results.add(book) |  | * |  |
| if(results.isEmpty()) |  | * | * |
| return null |  |  | * |
| return results |  | * |  |

За да се исполни Every Statement критериумот за функцијата searchBookByTitle, потребни се минимум 3 тест случаи.

## Тест случаи според критериумот Every branch
| Гранка/Branch | Test 1–Empty input | Test 2–Book available | Test 3–Already borrowed | Test 4–Book not found |
|---|---|---|---|---|
| if(title.isEmpty() \|\| author.isEmpty())-true | * |  |  |  |
| if(title.isEmpty() \|\| author.isEmpty())-false |  | * | * | * |
| if(book title && author match)-true |  | * | * |  |
| if(book title && author match)-false |  |  |  | * |
| if(!book.isBorrowed())-true |  | * |  |  |
| if(!book.isBorrowed())-false |  |  | * |  |
| throw IllegalArgumentException | * |  |  |  |
| book.setBorrowed(true) |  | * |  |  |
| throw RuntimeException("Book is already borrowed.") |  |  | * |  |
| throw RuntimeException("Book not found") |  |  |  | * |

За да се исполни Every Branch критериумот за функцијата borrowBook, потребни се минимум 4 тест случаи.

## Тест случаи според критериумот Multiple condition
| Име на функција | Test 1-Empty title & empty author  | Test 2-Empty title | Test 3-Empty author | Test 4-Valid input |
|---|---|---|---|---|
| book.getTitle().equalsIgnoreCase(title) | T | T | F | F |
| !book.isBorrowed() | T | F | T | F |
| Резултат | T | F | F | F |

За да се исполни Multiple condition критериумот потребни се 4 тест случаи, бидејќи и двата услови содржат по два подуслови.
