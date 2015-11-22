Ext.application({
    name: 'DashboardJs',
    autoCreateViewport: true,
    appFolder: 'app',
    requires: ['DashboardJs.Global'],
    controllers: ['Wisma','MenuDashboard','Helpdesk']
});