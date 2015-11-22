Ext.define('DashboardJs.view.wisma.EmployeeWindow', {
	extend: 'Ext.window.Window',
	alias: 'widget.employeeWindow',
	
	requires: ['DashboardJs.view.wisma.EmployeeList'],
	
    layout: 'fit',
    modal:true,
    width: 600,
    height: 400,
    items: [{
    	xtype: 'employeeList'
    }]
});