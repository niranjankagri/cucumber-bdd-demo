# Manual test cases

The scenarios this project automates, written as a tester would run them by hand. Every case has an
ID; the Cucumber scenario that covers it carries the same ID in its name (`[TC-101] Test Login
Functionality`) and as a tag (`@TC-101`), so a failure in the report leads straight to the case
below.

Not listed: `ReportDemo.feature`, which fails and skips on purpose to show the report.

## Setup

- TC-101: <https://the-internet.herokuapp.com/>, user `tomsmith`, password `SuperSecretPassword!`.
- TC-102: Pattern Shop at <http://localhost:8080/login> (`docker run -d -p 8080:8080 ghcr.io/niranjankagri/pattern-shop-demo-app`)
  or the hosted demo <https://pattern-shop.onrender.com/login>; password `secret_sauce` for every user.
  (Both from `src/test/resources/config.properties`.)

## Summary

| ID | Title | Type | Priority | Feature file (runner) |
|---|---|---|---|---|
| TC-101 | Login on the practice site reaches the secure area | Smoke | High | `cucumber.feature` (`TestRunner`) |
| TC-102 | Pattern Shop login with several users (4 data sets) | Regression | High | `Example.feature` (`ExampleRunner`, Scenario Outline) |

---

### TC-101 Login on the practice site reaches the secure area

| # | Step | Expected result |
|---|---|---|
| 1 | Open <https://the-internet.herokuapp.com/> | The practice site's list of examples |
| 2 | Click **Form Authentication** | Login form |
| 3 | Username `tomsmith`, password `SuperSecretPassword!`, click **Login** | Message "You logged into a secure area!"; URL ends with `/secure` |

### TC-102 Pattern Shop login with several users

For every data set: open the shop's sign-in page, enter the user and `secret_sauce`, click
**Sign in**. Expected: the page shows the text in the last column.

| Data set | Username | Expected text |
|---|---|---|
| 1 | `standard_user` | Products |
| 2 | `locked_user` | This user has been locked out. |
| 3 | `problem_user` | Products |
| 4 | `slow_user` | Products (the page takes about 3 seconds to open) |
