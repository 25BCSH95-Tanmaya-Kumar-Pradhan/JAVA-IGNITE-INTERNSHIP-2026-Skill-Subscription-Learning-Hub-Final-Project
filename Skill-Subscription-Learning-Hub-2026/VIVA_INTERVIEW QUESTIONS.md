# Viva / Interview Questions

##  Basic

- What is Spring Boot?

ANS:- Spring Boot is a Java framework used to create web applications and REST APIs quickly with less configuration. It provides auto-configuration, embedded servers, and easy database connection.

- What is MVC architecture?

ANS:- MVC stands for "Model View Controller" where,
Model : Handles data/entity (Example: User, SkillPack)
View : Handles UI pages (Example: JSP)
Controller : Handles user requests and connects Model with View

---

##  Intermediate

- What is Service layer?

ANS:- Service layer contains the business logic of the application. Controller calls Service, and Service communicates with Repository.
Controller -> UserService -> UserRepository -> Database

- What is Repository in Spring Data JPA?

ANS:- Repository is the layer used to communicate with the database. It provides CRUD operations like:
save()
findAll()
findById()
deleteById()

- Difference between GET and POST?

ANS:- 
GET: 1. Its used to retrieve data 2. Data is sent in URL
POST: 1. Its used to send/save data 2. Data is sent in request body

---

##  Advanced (Project Based)

- How does subscription flow work?

ANS:- 
1. First user clicks on the 'Subscribe'
2. Then, the control flows to SubscriptionController
3. After that it flows to the SubscriptionService
4. There a Subscription object is created
5. Then save using SubscriptionRepository
6. Database

- How do you link User and SkillPack?

ANS:- We create a relationship using the Subscription entity.
User -> Subscription -> SkillPack

- Why do we use Service layer?
  
ANS:- We use Service layer to separate business logic from Controller.
Benefits:
1.Cleaner code
2.Easy maintenance
3.Controller only handles requests
4.Logic can be reused

- How does JSP get data from Controller?
  
ANS:- Controller sends data using Model where,
Controller -> model.addAttribute() -(JSP)-> Displays data
