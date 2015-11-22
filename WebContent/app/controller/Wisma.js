Ext.define('DashboardJs.controller.Wisma', {
	extend: 'Ext.app.Controller',
	
	requires:['Ext.window.MessageBox'],
	
	stores: ['wisma.Wisma','wisma.Employee'],
	
	models: ['wisma.Wisma','wisma.Employee'],
	
	views: ['wisma.List','wisma.EmployeeWindow','wisma.EmployeeList'],
	
	refs: [{
        ref: 'employeeWindow',
        selector: 'employeeWindow',
        autoCreate: true,
        xtype: 'employeeWindow'
    },{
    	 ref: 'employeeList',
         selector: 'employeeWindow > employeeList',
         xtype: 'employeeList'
    }],
    
    init: function() {
        this.control({
        	'button[action=show]': {
        		click: this.showEmployee
        	}
        });
    },
    showEmployee: function(btn) {
    	//console.log(btn.text);
    	var employeeWindow = this.getEmployeeWindow();
    	employeeWindow.title = 'Detail Employee Wisma ' + btn.text;
    	var storeEmployee = this.getEmployeeList().getStore();
//    	storeEmployee.storeId = btn.text;
//    	storeEmployee.load({
//    		params:{'wisma': btn.text}
//    	});
    	storeEmployee.getProxy().setExtraParam("wisma", btn.text);
    	storeEmployee.load();
    	//console.log(storeEmployee);
    	employeeWindow.show();
    }
});