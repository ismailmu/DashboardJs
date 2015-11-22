Ext.define('DashboardJs.view.wisma.EmployeeList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.employeeList',
	requires : [ 'Ext.ux.grid.FiltersFeature', 'Ext.util.Point' ],
//	title : 'Wisma List',
//	iconCls : 'table16',
	loadMask : true,
	forceFit: true,
	initComponent : function() {
		this.store = 'wisma.Employee',
		this.columns = [
		    Ext.create('Ext.grid.RowNumberer',{resizable: true,width:30}), {
				header : 'Employee Name',
				dataIndex : 'employeeName',
				width : 130,
				sortable : true,
				filterable: true
			}, {
				header : 'Email',
				dataIndex : 'email',
				//flex : 1,
				sortable : true
			}, {
				header : 'Telephone',
				dataIndex : 'telephone',
				//flex : 1,
				sortable : true
			}, {
				header : 'Hp',
				dataIndex : 'hp',
				//width: 50,
				sortable : true
			}, {
				header : 'Position',
				dataIndex : 'position',
				width: 150,
				sortable : true
			}],
		this.dockedItems = [ {
			xtype : 'pagingtoolbar',
			store : 'wisma.Employee',
			dock : 'bottom',
			displayInfo : true
		}], 
		this.features = {
			ftype : 'filters',
			encode : true, // json encode the filter query
			local : false,
			filters : [ {
				type : 'string',
				dataIndex : 'employeeName'
			} ]
		};
		
		this.callParent(arguments);
	}
});
		