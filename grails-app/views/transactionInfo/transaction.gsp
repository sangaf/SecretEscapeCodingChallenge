<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>See transactions</title>
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
<div>
    <h2>Transaction Details</h2>
    <br/>

    <div class="error"></div>

    <form method="post">
        <label for="accountList"><strong>Person:</strong></label>
        <select id="accountList" name="accountName">
            <option value="">Select an account ...</option>
            %{ accounts.each { account -> }%
            <option value="${account.name}">${account.name}</option>
            %{ }
            }%
        </select>

        <br/>
        <br/>
        <input type="submit" name="showAccount" value="Show Account Details" class="btn-block"/>
    </form>
    <br/>

    <div><strong>Name</strong>: ${account?.name}</div>

    <div><strong>Balance</strong>: <g:formatNumber number="${account?.balance}" type="currency" currencyCode="GBP"/>
    </div>
    <br/>

    <h3>Transaction History</h3>

    <table>
        <thead>
        <tr>
            <td><strong>Date</strong></td>
            <td><strong>Description</strong></td>
            <td><strong>Amount</strong></td>
        </tr>
        </thead>
        <tbody>
        %{ if (accountHistory?.isEmpty()) { }%
        <tr>
            <td>..</td>
            <td>..</td>
            <td>..</td>
        </tr>
        %{
            } else {

                accountHistory.each { history -> }%
        <tr>
            <td><g:formatDate date="${history.date}" format="dd-MM-yyyy"/></td>
            <td>${history.description}</td>
            <td><g:formatNumber number="${history.amount}" type="currency" currencyCode="GBP"/></td>
        </tr>
        %{ }
        } }%
        </tbody>

    </table>
</div>
</body>
</html>