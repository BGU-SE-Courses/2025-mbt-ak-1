    # Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [OpenCart](https://address-of-the-project.com).

General Description: The software implements a mobile store. Users can add or remove items and buy products.

## Installation
Instructions: To install OpenCart and set up the testing environment, follow these steps:

Download the latest release of OpenCart from the official website.
Download and install XAMPP server.
Follow the installation instructions provided in the OpenCart documentation.
Set up the enviorement and configure the necessary settings.


## What we tested
*Module and User Stories:*
We tested the OpenCart that allows for adding and checks out products. We chose to test the following user stories:

*Module and User Stories:*

### User Checks Out a Product

- *User story:* User checks out a product.
   - *Preconditions:* The user is in OpenCart main page.
   - *Steps:*
      1. User adds product to the shopping cart.
      2. User navigates to the shopping cart.
      3. User Clicks on the "Checkout" button.
   - *Expected outcome:* The user sees the checkout page, with the chosen product in the order summery.

### Admin Changes a Product's Price

- *User story:* Admin changes product price.
   - *Preconditions:* The admin is in the login page.
   - *Steps:*
      1. Admin logs in to the system.
      2. The admin navigates to the product's catalog page.
      3. The admin selects a product.
      4. The admin changes the product's price. 
   - *Expected outcome:* The product's price is successfully updated, and the changes reflect across the system.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.

## Detected Bugs
We detected the following bugs:

1. Bug 1: 
    1. General description: Whenever the graph is too big, it doesn't fit in the PDF.
    2. Steps to reproduce: ./provengo analyze -f pdf testOpenCartSite
    3. Expected result: PDF file with the graph
    4. Actual result: PDF file with the graph, but the graph is too big and doesn't fit in the page so it's cut off.
