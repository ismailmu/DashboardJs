Ext.define('DashboardJs.model.menu.MenuModel', {
    extend: 'Ext.data.Model',
    
    fields: [
//         {name: 'id',  type: 'int'},
	     {name: 'xtype',  type: 'string'},
	     {name: 'text', type: 'string'},
	     {name: 'iconCls', type: 'string'},
	     {name: 'action', type: 'string'},
	     {name: 'menu', type: 'string'}
    ]//,idProperty: 'id'
});