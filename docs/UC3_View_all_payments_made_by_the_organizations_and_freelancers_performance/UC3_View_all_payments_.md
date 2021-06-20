# UC3- View all payments made by the organizations and freelancers performance

## 1. Requirements Engineering


### Brief Format

The Administrator **starts the functionality of viewing all payments** made by organizations to freelancers and freelancers performance. The system asks how the adminstrator wants to classify freelancers by name or payment value. Collaborator inserts the data.   The system **validates and asks for confirmation.** The collaborator confirms. The system **presents all the information** related to payments made by organizations and also presents the performance of freelancers.

### SSD
![UC3_SSD.svg](UC3_SSD.svg)

### Full Format

#### Main actor

* Administrator

#### Stakeholders and their interests

* **Administrator:** can have access to information about the payments and performance of freelancers.

#### Preconditions

* There are payments made.
* There will be performance records of freelancers.

#### Post-conditions

* The Administrator can consult the information on the payments and the performance of freelancers.

#### Main success scenario (or basic stream)

1. The Administrator **starts the functionality of viewing all payments** made by organizations to freelancers and freelancers performance.
2. The system asks how the adminstrator wants to classify freelancers by name or payment value.
3. Collaborator inserts the data.
4. The system **validates and asks for confirmation.**
5. The collaborator confirms.
6. The system **presents all the information** related to payments made by organizations and also presents the performance of freelancers.

#### Extensions (or alternate streams)
*2a. There are no registered freelancers.

> The use case ends.

*2b. There are no payments made.

> The use case ends.

*2c. There are no performance records.

> The use case ends.

#### Special requirements
-

#### List of Technology and Data Variations
-

#### Frequency of Occurrence
-

#### Open questions

* Should it be delivered an recipe to _Freelancer_ describing all the details of the payments?




## 2. OO Analysis

### Excerpt from the Relevant Domain Model for UC

![UC3_MD.svg](UC3_MD.svg)


## 3. Design - Use Case Realization

### Rational

| Main Flow | Question: Which Class... | Answer  | Justification  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. The Administrator starts the functionality of viewing all payments made by organizations to freelancers and freelancers performance.|...interact with the user?| ViewPaymentUI |Pure Fabrication|
| |...coordinates the UC?| ViewPaymentController |Controller|
|2. The system asks how the adminstrator wants to classify freelancers by name or payment value.
|3. Collaborator inserts the data.| ...save the data entered?|Plataform| In the DM the Plataform create Payment.|
|||PaymentList|Por aplicação de HC+LC delega a TaskList|
|||Payment|IE: Task conhece os seus dados|
|4. The system validates and asks for confirmation. |... validates the data of the payment (local validation)? | Payment | IE: has its own data |
|| ... validates os dados do Payment (global validation)? | PaymentList | IE: In the DM the Platform create Payment. By aplication of HC+LC delegates a PaymentList. |
|5. The collaborator confirms.
|6. The system presents all the information related to payments made by organizations and also presents the performance of freelancers.|... validates Payment data (local validation)| Payment |IE: has its own data
| |... validates Payment data (global validation)	| ViewPayment	| IE: ViewPayment has all Payment information |



### Systematization ##

  It follows from the rational that the conceptual classes promoted to software classes are:

 * Platform
 * Administrator
 * Organization
 * _Freelancer_
 * Payment
 * Transaction


Other software classes (i.e. Pure Fabrication) identified:

 * ViewPaymentUI
 * ViewPaymentController
 * ViewPayment


 ### Sequence Diagram

![UC3_SD.svg](UC3_SD.svg)

![SD_GetAllPayments.svg](SD_GetAllPayments.svg)

![SD_GetAllTasks.svg](SD_GetAllTasks.svg)
###	Class Diagram

![UC3_CD.svg](UC3_CD.svg)
