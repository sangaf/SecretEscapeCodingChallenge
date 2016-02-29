<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>PaySomePerson</title>
    <meta name="layout" content="main"/>
    <style>
    .error {
        color: red;
    }

    div {
        padding: 10px;
    }
    </style>
</head>

<body>
<div class="error">
    %{ if (command?.hasErrors()) { }%
    Transaction is unsuccessfull.
    <br/>
    ${command.errors.globalError.defaultMessage}
    <br/>
    %{ } }%
</div>

<div>
    <h2>Pay</h2>

    <form method="post">
        <label for="accountFrom"><strong>From:</strong></label>
        <select id="accountFrom" name="accountFrom">
            <option value="">Select an account ...</option>
            %{ accounts.each { account -> }%
            <option value="${account.name}" %{ if (command?.accountFrom == account.name) { }%selected %{
                    } }%>${account.name}</option>
            %{ }
            }%
        </select>
        <br/>
        <br/>
        <label for="accountTo"><strong>To:</strong></label>
        <select id="accountTo" name="accountTo">
            <option value="">Select an account ...</option>
            %{ accounts.each { account -> }%
            <option value="${account.name}" %{ if (command?.accountTo == account.name) { }%selected %{
                    } }%>${account.name}</option>
            %{ }
            }%
        </select>
        <br/>
        <br/>
        <label for="amount"><strong>Amount:</strong></label>
        <input type="text" name="amount" id="amount" maxlength="100" value="${command?.amount}"/>
        <br/>
        <br/>
        <input type="submit" name="transferAccount" value="Transfer" class="btn-block"/>
    </form>
    <br/>
    <br/>
    %{ if (transactionSuccessful) { }%
    <div style="color: #255b17"><strong>Transaction is successful</strong></div>
    <br/>
    <h4>Account Update</h4>
    <table>
        <thead>
        <tr>
            <td><strong>Account Name</strong></td>
            <td><strong>Current Account Balance</strong></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${command?.accountFrom}</td>
            <td>${fromBalance}</td>
        </tr>
        <tr>
            <td>${command?.accountTo}</td>
            <td>${toBalance}</td>
        </tr>
        </tbody>
    </table>
    %{ } }%

</div>

</body>
</html>