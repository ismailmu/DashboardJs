Ext.define('DashboardJs.controller.Helpdesk', {
	extend: 'Ext.app.Controller',
	
	views:['helpdesk.List'],
	
	stores: ['helpdesk.Helpdesk'],
	
	models: ['helpdesk.Helpdesk']//,
	
//	refs:[{
//		ref: 'helpdeskDailyList',
//		selector: 'helpdeskDailyList'
//	}],
//	
//	init: function() {
//        this.control({
//        	'button[action=show]': {
//        		click: this.showEmployee
//        	}
//        });
//    },
});