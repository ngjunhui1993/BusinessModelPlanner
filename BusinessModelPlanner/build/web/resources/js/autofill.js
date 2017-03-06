
(function() {
  angular.module('sample',['angular.chips','ui.bootstrap'])
        .controller('basicController', BasicController);

    function BasicController() {
      this.companies = ['Apple', 'Cisco', 'Verizon', 'Microsoft'];
        /*for bootstrap.ui.typeahead example*/
        this.availableCompanies = ['ACCO Brands',
            'Apple iTunes, Dell',
            'Patients like me',
            'Amazon',
            'Dell',
            'Ryan Air',
            'Toyota',
            'Starbucks',
            'McDonalds',
            'Google',
            'Body Shop',
            'Nike',
            'Li and Fung',
            'SAP',
            'IBM',
            'Rolls Royce',
            'CISCO',
            
            
        ];
    }
})();