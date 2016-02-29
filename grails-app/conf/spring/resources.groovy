// Place your Spring DSL code here

import grails.plugin.mail.MailMessageBuilderFactory
import grails.plugin.mail.MailMessageContentRenderer
import grails.plugin.mail.MailService
import org.springframework.mail.MailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import secretescapecodingchallenge.Accounts
import secretescapecodingchallenge.AccountTransactionHistory
import secretescapecodingchallenge.SEMailService


beans = {
    accounts(Accounts) { bean ->
        bean.autowire = 'byName'
    }

    accountTransactionHistory(AccountTransactionHistory){ bean ->
        bean.autowire = 'byName'
    }

    mailSender(JavaMailSenderImpl){
        def props = new Properties()
        props.setProperty('mail.transport.protocol', 'smtp')
        props.setProperty('mail.smtp.port', '3025')
        props.setProperty('mail.smtp.host', 'localhost')

        javaMailProperties = props
    }
    mailMessageContentRenderer(MailMessageContentRenderer)

    mailMessageBuilderFactory(MailMessageBuilderFactory) {
        mailSender = mailSender
        mailMessageContentRenderer = mailMessageContentRenderer
    }


    mailService(MailService){
        grailsApplication = grailsApplication
        mailMessageBuilderFactory = mailMessageBuilderFactory
    }


    seMailService(SEMailService){
        mailService = mailService
    }

}
