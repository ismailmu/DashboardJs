Ext.define('DashboardJs.model.helpdesk.Helpdesk', {
extend: 'Ext.data.Model',
    
    fields: [
         {name: 'id',  type: 'int'},
	     {name: 'ticketId', type: 'int'},
	     {name: 'wisma', type: 'string'},
	     {name: 'wismaName', type: 'string'},
	     {name: 'status', type: 'string'},
	     {name: 'priority', type: 'string'},
	     {name: 'aging', type: 'int'},
	     {name: 'category1', type: 'string'},
	     {name: 'category2', type: 'string'},
	     {name: 'category3', type: 'string'},
	     {name: 'category4', type: 'string'}
    ],
    idProperty: 'id'
});