Feature: User Registration
I want to check that the user can register successfully to our e-commerce website.

Scenario: User Registration
Given The user is in the home page
When He clicks on Register link
And He Enters "<firstName>", "<lastName>", "<email>", "<Password>"
Then The registration page displayed successfully

Examples:
//inserting data table
| firstName | lastName | email | Password |
| Marina | Hatem | mhhh@gmail.com | 123456789 |
| Kirolos | Maged | kmm@gmail.com | 147852369 |