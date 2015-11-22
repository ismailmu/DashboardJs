Ext.define('DashboardJs.store.wisma.Wisma', {
    extend: 'Ext.data.Store',
    model: 'DashboardJs.model.wisma.Wisma',
    //requires:'Ext.util.Point',
    autoLoad: false,
    pageSize: DashboardJs.Global.pageSize,
    remoteSort: true,
    remoteFilter:true,
    autoSizeColumns: true,
    proxy:{
        type: 'ajax',
        url : 'WismaServlet?type=list',
        reader: {
            root: 'wismas',
            totalProperty: 'totalCount'
        }
    },
    // sends single sort as multi parameter
    simpleSortMode: true,
    sorters: [{
        property: 'wisma',
        direction: 'ASC'
    }]
});