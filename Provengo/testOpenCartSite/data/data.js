/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */


const URLS = {
    MAIN_PAGE: 'http://localhost/opencartsite/',
    IPHONE_SEARCH_PAGE: 'http://localhost/opencartsite/index.php?route=product/search&search=iphone',
    ADMIN_LOGIN_PAGE: 'http://localhost/opencartsite/project_admin/',
    IPHONE_OPTIONS_PAGE: 'http://localhost/opencartsite/project_admin/index.php?route=catalog/product.form&user_token=559884fd8f14ecdc2360cca37d5f5c1e&product_id=40'
}

const COMPONENTS = {
    MAIN_PAGE: {
        searchBar: '//*[@id="container"]/header/div/div/div[2]/form/input',
        searchButton: '//*[@id="container"]/header/div/div/div[2]/form/button'
    },

    ADMIN_LOGIN_PAGE: {
        usernameBar: '//*[@id="input-username"]',
        passwordBar: '//*[@id="input-password"]',
        loginButton: '//*[@id="form-login"]/div[3]/button',
    },

    SEARCH_PAGE: {
        addToCartButton: '//*[@id="product-list"]/div/div/div[2]/form/div/button[1]',
        checkoutButton: '//*[@id="cart"]/div/ul/li/div/p/a[2]',
        cartButton: '//*[@id="cart"]/div/button',
    },

    DASHBOARD_PAGE: {
        catalogButton: '//*[@id="menu-catalog"]/a',
        productsButton: '//*[@id="collapse-1"]/li[2]/a'
    },

    PRODUCTS_PAGE: {
        iphoneEditButton: '//*[@id="form-product"]/div[1]/table/tbody/tr[6]/td[7]/div/a'
    },
}

const XPATHS = {
    SEARCH_WINDOW: {
        searchBar: '//*[@id="container"]/header/div/div/div[2]/form/input',
        searchButton: '//*[@id="container"]/header/div/div/div[2]/form/button',
    },

    IPHONE_SEARCH_PAGE: {
        addToCartButton: '//*[@id="product-list"]/div/div/div[2]/form/div/button[1]',
        cartButton: '//*[@id="cart"]/div/button',
        checkoutButton: '//*[@id="cart"]/div/ul/li/div/p/a[2]'
    },

    ADMIN_LOGIN_PAGE: {
        UsernameBar: '//*[@id="input-username"]',
        PasswordBar: '//*[@id="input-password"]',
        LoginButton: '//*[@id="form-login"]/div[3]/button',
    },

    DASHBOARD_PAGE: {
        catalogButton: '//*[@id="menu-catalog"]/a',
        productsButton: '//*[@id="collapse-1"]/li[2]/a'
    },

    PRODUCTS_PAGE: {
        iphoneEditButton: '//*[@id="form-product"]/div[1]/table/tbody/tr[6]/td[7]/div/a'
    },

    IPHONE_OPTIONS_PAGE: {
        dataButton: '//*[@id="form-product"]/ul/li[2]/a',
        priceBar: '//*[@id="input-price"]',
        saveButton: '//*[@id="content"]/div[1]/div/div/button'
    }
}

const EVENTS = {
    ADMIN: {
        S_LOGIN: 'START(Admin login)',
        S_GOES_TO_CATALOG: 'START(Admin goes to catalog)',
        S_GOES_TO_PRODUCTS: 'START(Admin goes to products)',
        S_GOES_TO_IPHONE_EDIT_PAGE: 'START(Admin goes to iphone edit page)',
        S_GOES_TO_IPHONE_DATA_PAGE: 'START(Admin goes to iphone data page)',
        S_CHANGES_IPHONE_PRICE: 'START(Admin changes iphone price)',

        E_LOGIN: 'END(Admin login)',
        E_GOES_TO_CATALOG: 'END(Admin goes to catalog)',
        E_GOES_TO_PRODUCTS: 'END(Admin goes to products)',
        E_GOES_TO_IPHONE_EDIT_PAGE: 'END(Admin goes to iphone edit page)',
        E_GOES_TO_IPHONE_DATA_PAGE: 'END(Admin goes to iphone data page)',
        E_CHANGES_IPHONE_PRICE: 'END(Admin changes iphone price)',
    },

    USER: {
        S_SEARCH: 'START(User searches iphone)',
        S_ADD_TO_CART: 'START(User adds iphone to cart)',
        S_CHECKOUT: 'START(User checks-out iphone)',

        E_SEARCH: 'END(User searches iphone)',
        E_ADD_TO_CART: 'END(User adds iphone to cart)',
        E_CHECKOUT: 'END(User checks-out iphone)',
    }
}