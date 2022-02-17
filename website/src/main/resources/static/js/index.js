let productCategoryApp = new Vue({
    el: '#productCategory',
    data: {
        productCategoryList: []
    },
    methods: {
        loadProductCategoryList(){
            $.ajax({
                url: "/product_categorys/list",
                type: "get",
                success: function (r) {
                    productCategoryApp.productCategoryList = r.data;
                }
            });
        }
    },
    created: function () {
        this.loadProductCategoryList();
    }
})
let newsCategoryApp = new Vue({
    el: '#newsCategory',
    data: {
        newsCategoryList: []
    },
    methods: {
        loadNewsCategoryList(){
            $.ajax({
                url: "/news_categorys/list",
                type: "get",
                success: function (r) {
                    newsCategoryApp.newsCategoryList = r.data;
                }
            });
        }
    },
    created: function () {
        this.loadNewsCategoryList();
    }
})

