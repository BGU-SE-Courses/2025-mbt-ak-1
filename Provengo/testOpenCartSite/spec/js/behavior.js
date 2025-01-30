/* @provengo summon selenium */

let USER = new SeleniumSession('USER')
let ADMIN = new SeleniumSession('ADMIN')

/**
 * runs the user scenario
 * 1. starts at the main page
 * 2. searches for iphone
 * 3. adds to cart
 * 4. user check-out
 */
bthread('user', function () {
    USER.start(URLS.MAIN_PAGE)
    USER.userSearch()
    USER.userAddToCart()
    USER.userCheckout()
    USER.close()
})

/**
 * runs the admin scenario
 * 1. starts session at the login page
 * 2. logs in
 * 3. goes to the iphone edit page
 * 4. edits the price and saves
 */
bthread('admin', function () {
    ADMIN.start(URLS.ADMIN_LOGIN_PAGE)
    ADMIN.adminLogin()
    ADMIN.adminGoToItemEditPage()
    ADMIN.adminChangesItemPrice()
    ADMIN.close()
})
