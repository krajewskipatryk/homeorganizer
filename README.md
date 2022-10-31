About:
=

Home Organizer is an application to help you with maintaining everyday housework.
You can make a shopping list and track whose turn for buying certain products currently is.
In home organizer you can add your own products and decide what house works you want to maintain
for all house members. Track your progress and make life easier with home organizer.

How to use:
=

User:
-

**Create user:**

**POST** localhost/8080/customer/create\
**Body (requires Json type):**
```json5
{
  "firstName": "YOUR_FIRST_NAME",
  "lastName": "YOUR_LAST_NAME",
  "email": "YOUR_EMAIL",
  "password": "YOUR_PASSWORD"
}
```
**Get user info:**

**GET** localhost/8080/customer/get/:customerId

Group:
-

**Create group:**

**POST** localhost/8080/group/create\
**Body (requires Json type):**
```json5
{
  "name": "GROUP_NAME"
}
```

**Add housework functionality for group:**

**POST** localhost/8080/group/:groupId/add/housework

**Add shopping list functionality for group:**

**POST** localhost/8080/group/:groupId/add/shoppinglist

**List all users from group**

**GET** localhost/8080/group/get/:groupId/customers

**Get group information**

**GET** localhost/8080/group/get/:groupId

**Add user to the group**

**PUT** localhost/8080/group/update/:groupId/customer/:customerId/add

**Remove user to the group**

**PUT** localhost/8080/group/update/:groupId/customer/:customerId/remove

Task:
-

**Add new task to the schedule list:**

**POST** localhost/8080/task/housework/:houseworkId/add/tasktype\
**Body (requires Json type):**
```json5
{
  "name": "TASK_NAME"
}
```

**Perform task:**

**POST** localhost/8080/task/housework/task/:taskTypeId/customer/:customerId/perform

**Add new product to the shopping list:**

**POST** localhost/8080/task/shoppinglist/:shoppinglistId/product/add\
**Body (requires Json type):**
```json5
{
  "name": "PRODUCT_NAME"
}
```

**Add bought product:**

**POST** localhost/8080/task/shoppinglist/product/:productId/customer/:customerId/perform

**Get task history for user:**

**GET** localhost/8080/task/customer/:customerId/history

**Get history for certain task:**

**GET** localhost/8080/task/taskType/:taskTypeId/history

**Get task history for user on certain task**

**GET** localhost/8080/task/customer/:customerId/taskType/:taskTypeId/history

**Get shopping history for certain product:**

**GET** localhost/8080/task/product/:productId/history

**Get user's shopping history for certain product:**

**GET** localhost/8080/task/customer/:customerId/product/:productId/history
