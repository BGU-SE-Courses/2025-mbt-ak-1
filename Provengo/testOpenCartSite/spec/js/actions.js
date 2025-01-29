/* @provengo summon selenium */

// @provengo summon selenium
const AnyStartInSession = function (s) {
    return EventSet(
        `AnyStartInSession-${s}`,
        e => e.data && 'startEvent' in e.data && e.data.startEvent && s.name === e.data.session.name
    )
}

defineAction = function (name, func) {
    SeleniumSession.prototype[name] = function (session, data) {
        session = this

        sync({request: Event(`Start(${name})`,
                {session: session, startEvent: true, parmeters: data})  })

        block(AnyStartInSession(session), function () {
            func(session, data)

            sync({request: Event(`End(${name})`,
                    {session: session, endEvent: true, parmeters: data})  })
        })
    }
}


// defining actions

defineAction("adminLogin", function (session) {
    session.writeText(COMPONENTS.ADMIN_LOGIN_PAGE.usernameBar, 'admin')
    session.writeText(COMPONENTS.ADMIN_LOGIN_PAGE.passwordBar, 'admin')
    session.click(COMPONENTS.ADMIN_LOGIN_PAGE.loginButton)
})

defineAction('adminGoToItemEditPage', function (session) {
    session.click(COMPONENTS.DASHBOARD_PAGE.catalogButton)
    session.click(COMPONENTS.DASHBOARD_PAGE.productsButton)
    session.click(COMPONENTS.PRODUCTS_PAGE.iphoneEditButton)
})

defineAction("userSearch", function (session) {
    session.writeText(COMPONENTS.MAIN_PAGE.searchBar, 'iPhone')
    session.click(COMPONENTS.MAIN_PAGE.searchButton)
})

defineAction("userAddToCart", function (session) {
    session.click(COMPONENTS.SEARCH_PAGE.addToCartButton)
})

defineAction("userCheckout", function (session) {
    session.click(COMPONENTS.SEARCH_PAGE.cartButton)
    session.click(COMPONENTS.SEARCH_PAGE.checkoutButton)
    session.assertText('//*[@id="checkout-confirm"]/div[1]/table/tbody/tr/td[1]/text()', '1x ')
    session.assertText('//*[@id="checkout-confirm"]/div[1]/table/tbody/tr/td[1]/a', 'iPhone')
})

