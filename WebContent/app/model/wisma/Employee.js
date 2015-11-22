Ext.define('DashboardJs.model.wisma.Employee', {
    extend: 'Ext.data.Model',
    
    fields: [
         {name: 'id',  type: 'int'},
	     {name: 'employeeName',  type: 'string'},
	     {name: 'email', type: 'string'},
	     {name: 'telephone', type: 'string'},
	     {name: 'hp', type: 'string'},
	     {name: 'position', type: 'string'}
    ],
    idProperty: 'id'
});