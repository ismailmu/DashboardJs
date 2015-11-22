Ext.define('DashboardJs.store.wisma.Employee', {
    extend: 'Ext.data.Store',
    model: 'DashboardJs.model.wisma.Employee',
    autoLoad: false,
    pageSize: DashboardJs.Global.pageSize,
    remoteSort: true,
    remoteFilter: true,
    //autoSizeColumns: true,
    proxy:{
        type: 'ajax',
        url : 'WismaServlet?type=employee',
        reader: {
            root: 'wismaEmployees',
            totalProperty: 'totalCount'
        }
    },
//    listeners: {
//        beforeload: function(store, options,operation) {
//        	//console.log(options.params);
//        	//options.params.wisma=store.storeId;
//        }
//    },
    // sends single sort as multi parameter
    simpleSortMode: true
});