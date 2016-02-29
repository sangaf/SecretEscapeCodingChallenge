package secretescapecodingchallenge

import grails.plugin.mail.MailService


class SEMailService {
    MailService mailService

    static transactional = false

    def mailTo(Map mailMap) {
        mailService.sendMail {
            to mailMap.to
            subject mailMap.subject
            body mailMap.body
        }

    }
}
