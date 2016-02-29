Run the project (./grailsw run-app)

To see the transaction page : go to http://localhost:8080/secretescapecodingchallenge/transaction

Then to see an accounts transaction history, select account from the account drop down box and click “show account details” button
Then in the bottom of the page some transaction will be displayed.

To transfer from one account to another account: browse to http://localhost:8080/secretescapecodingchallenge/pay

Select account from From drop down box to transfer 
Select account from To dropdown box to credit the account
Insert amount to Amount input box
Click “Transfer” button

If “From Account” has sufficient balance, then the amount will be debited and “To Account” will be credited and a table will show the changed balance of the both of the accounts.

Go to http://localhost:8080/secretescapecodingchallenge/greenmail to confirm that mail has been sent to the both of the accounts.

If “From Account” does not have balance less then the amount to be debited, then error message will be shown in the page.