/* @provengo summon selenium */

// @provengo summon constraints
// @provengo summon selenium
let USER = new SeleniumSession('USER')
let ADMIN = new SeleniumSession('ADMIN')

bthread('User check out item', function () {
    USER.start(URLS.MAIN_PAGE)
    USER.userSearch()
    USER.userAddToCart()
    USER.userCheckout()
    USER.close()
})



