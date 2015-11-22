Ext.define('DashboardJs.view.helpdesk.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.helpdeskDailyList',

	// entah kenapa ada error aneh bin ajaib di function getpoint dibrowser
	// tapi anehnya masih bisa jalan
	// ditambahkan Ext.util.Point, error tidak lagi muncul
	requires : [ 'Ext.ux.grid.FiltersFeature'],// 'Ext.util.Point' ],
	title : 'Helpdesk Daily',
	iconCls : 'table16',
	loadMask : true,
	forceFit: true,
	initComponent : function() {
		this.store = 'helpdesk.Helpdesk',
		this.columns = [
			Ext.create('Ext.grid.RowNumberer',{resizable: true,width:30}), {
				header : 'Ticket ID',
				dataIndex : 'ticketId',
				//flex: 1,
				//width: 30,
				sortable : true
			}, {
				header : 'Wisma',
				dataIndex : 'wisma',
				//flex: 1,
				width: 60,
				sortable : true
			}, {
				header : 'Wisma Name',
				dataIndex : 'wismaName',
				//flex: 1,
				sortable : true
			}, {
				header : 'Status',
				dataIndex : 'status',
				//flex: 1,
				width:200,
				sortable : true
			}, {
				header : 'Priority',
				dataIndex : 'priority',
				//flex: 1,
				sortable : true
			}, {
				header : 'Aging',
				dataIndex : 'aging',
				//flex: 1,
				sortable : true
			}, {
				header : 'Category 1',
				dataIndex : 'category1',
				//flex: 1,
				sortable : true
			}, {
				header : 'Category 2',
				dataIndex : 'category2',
				//flex: 1,
				sortable : true
			}, {
				header : 'Category 3',
				dataIndex : 'category3',
				//flex: 1,
				sortable : true
			}, {
				header : 'Category 4',
				dataIndex : 'category4',
				//flex: 1,
				sortable : true
			}],
		this.dockedItems = [ {
			xtype : 'pagingtoolbar',
			store : 'helpdesk.Helpdesk', // same store GridPanel is using
			dock : 'bottom',
			displayInfo : true
		} ], 
		this.features = {
			ftype : 'filters',
			encode : true, // json encode the filter query
			local : false,
			filters : [ {
				type : 'string',
				dataIndex : 'wisma'
			} ]
		};

		this.callParent(arguments);
	}
});