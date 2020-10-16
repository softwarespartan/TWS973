package com.tws;

import com.ib.client.*;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.*;

public class Handler extends EmptyWrapper{

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public final ConcurrentHashMap<UUID, TWSEvent> eventQueue = new ConcurrentHashMap<>();


    private final Set<NotificationListener> notificationListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> realTimeBarListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> historicalDataListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> positionListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> accountSummaryListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> accountUpdateListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> portfolioUpdateListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> marketDataListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> marketMetadataListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> marketDepthListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> contractDetailsListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> openOrderListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> orderStatusListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> executionDetailsListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> nextOrderIdListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> errorListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> scannerDataListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> optionComputationListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> EFPListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> connectionClosedListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> commissionReportListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> marketRuleListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> headTimestampListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener,Boolean>());

    private final Set<NotificationListener> financialAdvisoryListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener, Boolean>());

    private final Set<NotificationListener> fundamentalDataListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener, Boolean>());

    private final Set<NotificationListener> symbolSampleListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener, Boolean>());

    private final Set<NotificationListener> tickByTickListeners
            = Collections.newSetFromMap(new ConcurrentHashMap<NotificationListener, Boolean>());


    private final ConcurrentHashMap<Integer,HistoricalDataEvent>  historicalDataMap = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Integer,PositionsEvent>       positionMap       = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Integer,AccountSummaryEvent>  accountSummaryMap = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Integer,ScannerDataEvent>     scannerDataMap    = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Integer,ContractDetailsEvent> contractDetailsMap = new ConcurrentHashMap<>();



    public void addNotificationListener      (NotificationListener listener) {
        System.out.println("notification listener has been added");
        this.notificationListeners.add(listener);
    }

    public void removeNotificationListener   (NotificationListener listener) {
        System.out.println("notification listener has been removed");
        this.notificationListeners.remove(listener);
    }



    public void addHistoricalDataListener    (NotificationListener listener) {
        System.out.println("historical data listener has been added");
        this.historicalDataListeners.add(listener);
    }

    public void removeHistoricalDataListener (NotificationListener listener) {
        System.out.println("historical data listener has been removed");
        this.historicalDataListeners.remove(listener);
    }



    public void addRealTimeBarListener       (NotificationListener listener) {
        System.out.println("realtime bar listener has been added");
        this.realTimeBarListeners.add(listener);
    }

    public void removeRealTimeBarListener    (NotificationListener listener) {
        System.out.println("realtime bar listener has been removed");
        this.realTimeBarListeners.remove(listener);
    }



    public void addPositionListener          (NotificationListener listener) {
        System.out.println("position listener has been added");
        this.positionListeners.add(listener);
    }

    public void removePositionListener       (NotificationListener listener) {
        System.out.println("position listener has been removed");
        this.positionListeners.remove(listener);
    }



    public void addAccountUpdateListener     (NotificationListener listener) {
        System.out.println("account update listener has been added");
        this.accountUpdateListeners.add(listener);
    }

    public void removeAccountUdateListener   (NotificationListener listener) {
        System.out.println("account update listener has been removed");
        this.accountUpdateListeners.remove(listener);
    }



    public void addPortfolioUpdateListener   (NotificationListener listener) {
        System.out.println("portfolio update listener has been added");
        this.portfolioUpdateListeners.add(listener);
    }

    public void removePortfolioUdateListener (NotificationListener listener) {
        System.out.println("portfolio update listener has been removed");
        this.portfolioUpdateListeners.remove(listener);
    }



    public void addAccountSummaryListener    (NotificationListener listener) {
        System.out.println("account summary listener has been added");
        this.accountSummaryListeners.add(listener);
    }

    public void removeAccountSummaryListener (NotificationListener listener) {
        System.out.println("account summary listener has been removed");
        this.accountSummaryListeners.remove(listener);
    }



    public void addMarketDataListener        (NotificationListener listener) {
        System.out.println("market data listener has been added");
        this.marketDataListeners.add(listener);
    }

    public void removeMarketDataListener     (NotificationListener listener) {
        System.out.println("market data listener has been removed");
        this.marketDataListeners.remove(listener);
    }



    public void addMarketMetadataListener    (NotificationListener listener) {
        System.out.println("market metadata listener has been added");
        this.marketMetadataListeners.add(listener);
    }

    public void removeMarketMetadataListener (NotificationListener listener) {
        System.out.println("market metadata listener has been removed");
        this.marketMetadataListeners.remove(listener);
    }



    public void addMarketDepthListener       (NotificationListener listener) {
        System.out.println("market depth listener has been added");
        this.marketDepthListeners.add(listener);
    }

    public void removeMarketDepthListener    (NotificationListener listener) {
        System.out.println("market depth listener has been removed");
        this.marketDepthListeners.remove(listener);
    }



    public void addContractDetailsListener   (NotificationListener listener) {
        System.out.println("contract details listener has been added");
        this.contractDetailsListeners.add(listener);
    }

    public void removeContractDetailsListener(NotificationListener listener) {
        System.out.println("contract details listener has been removed");
        this.contractDetailsListeners.remove(listener);
    }



    public void addOpenOrderListener         (NotificationListener listener) {
        System.out.println("open order listener has been added");
        this.openOrderListeners.add(listener);
    }

    public void removeOpenOrderListener      (NotificationListener listener) {
        System.out.println("open order listener has been removed");
        this.openOrderListeners.remove(listener);
    }



    public void addOrderStatusListener       (NotificationListener listener) {
        System.out.println("order status listener has been added");
        this.orderStatusListeners.add(listener);
    }

    public void removeOrderStatusListener    (NotificationListener listener) {
        System.out.println("order status listener has been removed");
        this.orderStatusListeners.remove(listener);
    }



    public void addExecutionDetailsListener  (NotificationListener listener) {
        System.out.println("execution details listener has been added");
        this.executionDetailsListeners.add(listener);
    }

    public void removeExecutionDetilsListener(NotificationListener listener) {
        System.out.println("execution details listener has been removed");
        this.executionDetailsListeners.remove(listener);
    }



    public void addNextOrderIdListener       (NotificationListener listener) {
        System.out.println("nextOrderId listener has been added");
        this.nextOrderIdListeners.add(listener);
    }

    public void removeNextOrderIdListener    (NotificationListener listener) {
        System.out.println("nextOrderId listener has been removed");
        this.nextOrderIdListeners.remove(listener);
    }



    public void addErrorListener             (NotificationListener listener) {
        System.out.println("error listener has been added");
        this.errorListeners.add(listener);
    }

    public void removeErrorListener          (NotificationListener listener) {
        System.out.println("error listener has been removed");
        this.errorListeners.remove(listener);
    }



    public void addScannerDataListener       (NotificationListener listener) {
        System.out.println("scanner data listener has been added");
        this.errorListeners.add(listener);
    }

    public void removeScannerDataListener    (NotificationListener listener) {
        System.out.println("scanner data listener has been removed");
        this.errorListeners.remove(listener);
    }



    public void addOptionComputationListener    (NotificationListener listener) {
        System.out.println("option computation listener has been added");
        this.optionComputationListeners.add(listener);
    }

    public void removeOptionComputationListener (NotificationListener listener) {
        System.out.println("option computation listener has been removed");
        this.optionComputationListeners.remove(listener);
    }



    public void addEFPListener       (NotificationListener listener) {
        System.out.println("EFP listener has been added");
        this.EFPListeners.add(listener);
    }

    public void removeEFPListener    (NotificationListener listener) {
        System.out.println("EFP listener has been removed");
        this.EFPListeners.remove(listener);
    }



    public void addConnectionClosedListener       (NotificationListener listener) {
        System.out.println("connection closed listener has been added");
        this.connectionClosedListeners.add(listener);
    }

    public void removeConnectionClosedListener    (NotificationListener listener) {
        System.out.println("connection closed listener has been removed");
        this.connectionClosedListeners.remove(listener);
    }



    public void addCommissionReportListener       (NotificationListener listener) {
        System.out.println("commission report listener has been added");
        this.commissionReportListeners.add(listener);
    }

    public void removeCommissionReportListener    (NotificationListener listener) {
        System.out.println("commission report listener has been removed");
        this.commissionReportListeners.remove(listener);
    }



    public void addMarketRuleListener       (NotificationListener listener) {
        System.out.println("market rule listener has been added");
        this.marketRuleListeners.add(listener);
    }

    public void removeMarketRuleListener    (NotificationListener listener) {
        System.out.println("market rule listener has been removed");
        this.marketRuleListeners.remove(listener);
    }


    public void addHeadTimestampListener       (NotificationListener listener) {
        System.out.println("headtimestamp listener has been added");
        this.headTimestampListeners.add(listener);
    }

    public void removeHeadTimestampListener    (NotificationListener listener) {
        System.out.println("headtimestamp listener has been removed");
        this.headTimestampListeners.remove(listener);
    }


    public void addFinancialAdvisoryListener    (NotificationListener listener) {
        System.out.println("financial advisory listener has been added");
        this.financialAdvisoryListeners.add(listener);
    }

    public void removeFinancialAdvisoryListener    (NotificationListener listener) {
        System.out.println("financial advisory listener has been removed");
        this.financialAdvisoryListeners.remove(listener);
    }


    public void addFundamentalListener    (NotificationListener listener) {
        System.out.println("fundamental data listener has been added");
        this.fundamentalDataListeners.add(listener);
    }

    public void removeFundamentalListener    (NotificationListener listener) {
        System.out.println("fundamental data listener has been removed");
        this.fundamentalDataListeners.remove(listener);
    }


    public void addSymbolSampleListener    (NotificationListener listener) {
        System.out.println("symbol sample listener has been added");
        this.symbolSampleListeners.add(listener);
    }

    public void removeSymbolSampleListener    (NotificationListener listener) {
        System.out.println("symbol sample listener has been removed");
        this.symbolSampleListeners.remove(listener);
    }



    public void addTickByTickListener    (NotificationListener listener) {
        System.out.println("tick by tick listener has been added");
        this.tickByTickListeners.add(listener);
    }

    public void removeTickByTickListener    (NotificationListener listener) {
        System.out.println("tick by tick listener has been removed");
        this.tickByTickListeners.remove(listener);
    }


    public TWSEvent getEvent          (UUID uuid) { return this.eventQueue.get(uuid);    }
    public TWSEvent getEventWithRemove(UUID uuid) { return this.eventQueue.remove(uuid); }



    private void notify(Set<NotificationListener> listeners, NotificationEvent event)     {

        // submit notification event
        //this.executorService.submit( new NotificationAction( listeners,event ) );

        // route everything to notification listeners for now
        try {
            this.executorService.submit(new NotificationAction(this.notificationListeners, event));
        }catch(RejectedExecutionException e){
            // no op (?)
        }
    }

    private void processEvent(com.tws.TWSEvent event, Set<NotificationListener> listeners){

        // create a UUID for this event
        final UUID uuid = UUID.randomUUID();

        // put market data event in the event queue with or without listeners
        this.eventQueue.put( uuid, event );

        // notify market depth listeners
        this.notify(listeners,new NotificationEvent(this,uuid));
    }

    public void shutdown(){

        // get the ball rolling
        this.executorService.shutdown();

        try {
            // Wait a while for existing tasks to terminate
            if (!this.executorService.awaitTermination(2, TimeUnit.SECONDS)) {

                // Cancel currently executing tasks
                this.executorService.shutdownNow();

                // Wait a while for tasks to respond to being cancelled
                if (!this.executorService.awaitTermination(2, TimeUnit.SECONDS))
                    System.err.println("handler executor service did not terminate");
            }
        } catch (InterruptedException ie) {

            // (Re-)Cancel if current thread also interrupted
            this.executorService.shutdownNow();

            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }



    public final class     NotificationEvent    extends    EventObject   {
        public final UUID    uuid   ;
        public NotificationEvent(Handler obj, UUID uuid) { super(obj); this.uuid = uuid; }
    }

    public       interface NotificationListener extends    EventListener {
        void TWSNotification(NotificationEvent event);
    }

    public final class     NotificationAction   implements Runnable      {
        private final Set<NotificationListener> listeners ;
        private final NotificationEvent         event     ;

        public NotificationAction(Set<NotificationListener> l,NotificationEvent e){
            this.listeners = l; this.event = e;
        }

        @Override
        public void run() {

            /** Java 8
            this.listeners.stream().forEach(l -> l.TWSNotification(this.event));
             */

            for (NotificationListener l : this.listeners){
                l.TWSNotification(this.event);
            }
        }
    }



    public class Event<T>          extends EventObject implements com.tws.TWSEvent {
        public final T    data;
        public final Date date;

        public Event(Object source, T data) { super(source); this.data = data; this.date = new Date(); }
    }

    public class AggregateEvent<T> extends EventObject implements com.tws.TWSEvent {
        public final int    reqId;
        public final Set<T> data ;
        public final Date   date ;

        AggregateEvent(Object obj,int reqId){
            super(obj); this.reqId = reqId;  this.data = new HashSet<>(); this.date = new Date();
        }
    }



    @Override
    public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
        this.processEvent(
                new RealTimeBarEvent(
                    this,new Bar(reqId,time,open,high,low,close,volume,wap,count)
                ),
                this.realTimeBarListeners
        );
    }

    public final class RealTimeBarEvent extends Event<Bar> {
        RealTimeBarEvent(Object obj, Bar bar) { super(obj,bar); }
    }



    @Override
    // public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double wap, boolean hasGaps)
    public void historicalData(int reqId, com.ib.client.Bar bar) {

        // box the request id for hashcode in map
        final Integer integerReqId = reqId;

        // next check if there is an entry in the historical data map for this request id
        if (!this.historicalDataMap.containsKey(integerReqId)){
            this.historicalDataMap.put(integerReqId, new HistoricalDataEvent(this,reqId));
        }

        try{
            // add this bar in the appropriate historical data event (i.e. build the event call by call)
            this.historicalDataMap.get(integerReqId).data.add(new com.tws.Bar(reqId, bar));
        } catch (ParseException e){

            // there was a problem parsing the date string
            e.printStackTrace();
        }
    }

    public final class HistoricalDataEvent extends AggregateEvent<Bar> {
        HistoricalDataEvent(Object obj,int reqId) { super(obj,reqId); }
    }

    @Override
    public void historicalDataEnd(int reqId, String startDateStr, String endDateStr) {

        // API 9.72+ calls this rather than date startsWith "finished"

        // box the request id for hashcode in map
        final Integer integerReqId = reqId;

        // extract the historical data event from the map
        HistoricalDataEvent historicalDataEvent = this.historicalDataMap.get(integerReqId);

        // remove from the data map
        this.historicalDataMap.remove(integerReqId);

        // queue this up for notification
        this.processEvent( historicalDataEvent, this.historicalDataListeners);
    }



    @Override
    public void position(String account, Contract contract, double pos, double avgCost) {

        // next check if there is an entry in the historical data map for this request id
        // NOTE:  for positions always set request id to 0 [yuk, i know].
        if (!this.positionMap.containsKey(0)){
            this.positionMap.put(0, new PositionsEvent(this,0));
        }

        // add this position in the appropriate position event (i.e. build the event call by call)
        this.positionMap.get(0).data.add(new Position(account, contract, pos, avgCost));
    }

    @Override
    public void positionEnd(){

        // if no positions key=0 never gets created
        if (!this.positionMap.containsKey(0)) return;

        // extract positions event from the map
        PositionsEvent positionsEvent = this.positionMap.get(0);

        // remove from the data map
        this.positionMap.remove(0);

        // queue this up for notification
        this.processEvent(positionsEvent,this.positionListeners);
    }

    public final class PositionsEvent extends AggregateEvent<Position>                  {
        PositionsEvent(Object obj,int reqId) { super(obj,reqId); }
    }



    @Override
    public void accountSummary(int reqId, String account, String key, String value, String currency) {

        // next check if there is an entry in the historical data map for this request id
        if (!this.accountSummaryMap.containsKey(reqId)){
            this.accountSummaryMap.put(reqId, new AccountSummaryEvent(this,reqId));
        }

        // add this position in the appropriate event (i.e. build the event call by call)
        this.accountSummaryMap.get(reqId).data.add(new AccountAttribute(key,value,currency,account));
    }

    @Override
    public void accountSummaryEnd(int reqId)                                                         {

        // extract the final aggregated event from the map
        AccountSummaryEvent summaryEvent = this.accountSummaryMap.get(reqId);

        // remove from the event map
        this.accountSummaryMap.remove(reqId);

        // process the event
        this.processEvent( summaryEvent, this.accountSummaryListeners);
    }

    public final class AccountSummaryEvent extends AggregateEvent<AccountAttribute>                  {
        public AccountSummaryEvent(Object obj,int reqId) { super(obj,reqId); }
    }



    @Override
    public void updateAccountValue(String key, String value, String currency, String accountName) {
        this.processEvent(
                new AccountUpdateEvent( this,
                        new AccountAttribute(key,value,currency,accountName)
                ),
                this.accountUpdateListeners
        );
    }

    public final class AccountUpdateEvent extends Event<AccountAttribute>                         {
        public AccountUpdateEvent(Object source, AccountAttribute data) { super(source, data); }
    }



    @Override
    public void updatePortfolio(Contract contract, double position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
        this.processEvent(
                new PortfolioUpdateEvent( this,
                        new PortfolioUpdate(contract,position,marketPrice,marketValue,averageCost,unrealizedPNL,realizedPNL,accountName)
                ),
                this.portfolioUpdateListeners
        );
    }

    public final class PortfolioUpdateEvent extends Event<PortfolioUpdate>{
        public PortfolioUpdateEvent(Object source, PortfolioUpdate data) { super(source, data); }
    }



    @Override
    public void tickPrice(int reqId, int field, double price, TickAttr attr) {

        if (field < 10) {
            this.processEvent(
                    new MarketDataEvent(this,
                            new MarketData(reqId, field, TickType.getField(field), price)
                    ),
                    this.marketDataListeners
            );
        } else {
            this.processEvent(
                    new MarketMetadataEvent(this,
                            new MarketMetadata(reqId, field, TickType.getField(field), Double.toString(price))
                    ),
                    this.marketMetadataListeners
            );
        }
    }

    @Override
    public void tickSize(int reqId, int field, int size)                     {

        if (field < 10) {
            this.processEvent(
                    new MarketDataEvent(this,
                            new MarketData(reqId, field, TickType.getField(field), size)
                    ),
                    this.marketDataListeners
            );
        } else {
            this.processEvent(
                    new MarketMetadataEvent(this,
                            new MarketMetadata(reqId, field, TickType.getField(field), Integer.toString(size))
                    ),
                    this.marketMetadataListeners
            );
        }
    }

    public final class MarketDataEvent extends Event<MarketData>             {
        public MarketDataEvent(Object source, MarketData data) { super(source, data); }
    }



    @Override
    public void tickGeneric(int reqId, int tickType, double value)      {
        this.processEvent(
                new MarketMetadataEvent(
                        this,new MarketMetadata(reqId,tickType,TickType.getField(tickType),Double.toString(value))
                ),
                this.marketMetadataListeners
        );
    }

    @Override
    public void tickString(int reqId, int tickType, String value)       {
        this.processEvent(
                new MarketMetadataEvent(
                        this,new MarketMetadata(reqId,tickType,TickType.getField(tickType),value)
                ),
                this.marketMetadataListeners
        );
    }

    public final class MarketMetadataEvent extends Event<MarketMetadata>{
        public MarketMetadataEvent(Object source, MarketMetadata data) { super(source, data); }
    }



    @Override
    public void updateMktDepth  (int reqId, int position,                     int operation, int side, double price, int size) {

        this.processEvent(
                new MarketDepthEvent(
                        this, new MarketDepth(reqId, position, operation, side, price, size)
                ),
                this.marketDepthListeners
        );
    }

    @Override
    public void updateMktDepthL2(int reqId, int position, String marketMaker, int operation, int side, double price, int size) {
        this.processEvent(
                new MarketDepthEvent(
                        this,new MarketDepth(reqId,position,marketMaker,operation,side,price,size)
                ),
                this.marketDepthListeners
        );
    }

    public final class MarketDepthEvent extends Event<MarketDepth>                                                             {
        public MarketDepthEvent(Object source, MarketDepth data) { super(source, data); }
    }



    @Override
    public void contractDetails(int reqId, com.ib.client.ContractDetails contractDetails) {

        Integer integerReqId = reqId;

        // next check if there is an entry in the historical data map for this request id
        if (!this.contractDetailsMap.containsKey(integerReqId)){
            this.contractDetailsMap.put(integerReqId, new ContractDetailsEvent(this, reqId));
        }

        // add this position in the appropriate event (i.e. build the event call by call)
        this.contractDetailsMap.get(integerReqId)
                .data.add(new ContractDetails(reqId, contractDetails));
    }

    @Override
    public void contractDetailsEnd(int reqId)                                             {

        // extract the final aggregated event from the map
        ContractDetailsEvent event = this.contractDetailsMap.get(reqId);

        // remove from the event map
        this.contractDetailsMap.remove(reqId);

        // process the event
        this.processEvent( event, this.contractDetailsListeners);
    }

    public final class ContractDetailsEvent extends AggregateEvent<ContractDetails>       {
        public ContractDetailsEvent(Object source, int reqId) { super(source, reqId); }
    }



    @Override
    public void openOrder(int orderId, Contract contract, Order order, OrderState orderState){
        this.processEvent(
                new OpenOrderEvent( this,
                        new OpenOrder(orderId,contract,order,orderState)
                ),
                this.openOrderListeners
        );
    }

    public final class OpenOrderEvent extends Event<OpenOrder>                               {
        public OpenOrderEvent(Object source, OpenOrder data)  { super(source, data); }
    }



    @Override
    public void orderStatus(int orderId, String status, double filled, double remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld,double mktCapPrice) {
        this.processEvent(
                new OrderStatusEvent( this,
                        new OrderStatus(orderId,status,filled,remaining,avgFillPrice,permId,parentId,lastFillPrice,clientId,whyHeld,mktCapPrice)
                ),
                this.orderStatusListeners
        );
    }

    public final class OrderStatusEvent extends Event<OrderStatus>{
        public OrderStatusEvent(Object source, OrderStatus data)  { super(source, data); }
    }



    @Override
    public void execDetails(int reqId, Contract contract, Execution execution){
        this.processEvent(
                new ExecutionDetailsEvent(this,
                        new ExecutionDetails(contract, execution)
                ),
                this.executionDetailsListeners
        );
    }

    public final class ExecutionDetailsEvent extends Event<ExecutionDetails>  {
        public ExecutionDetailsEvent(Object source, ExecutionDetails data) { super(source, data); }
    }



    @Override
    public void nextValidId(int orderId)                           {
        this.processEvent(
                new NextOrderIdEvent( this,
                        new NextOrderId(orderId)
                ),
                this.nextOrderIdListeners
        );
    }

    public final class NextOrderIdEvent extends Event<NextOrderId> {
        public NextOrderIdEvent(Object source, NextOrderId data) { super(source, data); }
    }



    @Override
    public void scannerData(int reqId, int rank, com.ib.client.ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {

        Integer integerReqId = reqId;

        // next check if there is an entry in the historical data map for this request id
        if (!this.scannerDataMap.containsKey(integerReqId)){
            this.scannerDataMap.put(integerReqId, new ScannerDataEvent(this,reqId));
        }

        // add this position in the appropriate event (i.e. build the event call by call)
        this.scannerDataMap.get(integerReqId)
                .data.add( new ScannerData(rank,contractDetails,distance,benchmark,projection,legsStr));
    }

    @Override
    public void scannerDataEnd(int reqId)                                  {

        // extract the final aggregated event from the map
        ScannerDataEvent event = this.scannerDataMap.get(reqId);

        // remove from the event map
        this.scannerDataMap.remove(reqId);

        // process the event
        this.processEvent( event, this.scannerDataListeners);
    }

    public final class ScannerDataEvent extends AggregateEvent<ScannerData>{
        ScannerDataEvent(Object obj, int reqId) { super(obj, reqId); }
    }



    @Override
    public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma, double vega, double theta, double undPrice) {
        this.processEvent(
                new OptionComputationEvent( this,
                        new OptionComputation(tickerId,field,impliedVol,delta,optPrice,pvDividend,gamma,vega,theta,undPrice)
                ),
                this.optionComputationListeners
        );
    }

    public final class OptionComputationEvent extends Event<OptionComputation>{
        public OptionComputationEvent(Object source, OptionComputation data) { super(source, data); }
    }


    @Override
    public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
        this.processEvent(
                new EFPEvent( this,
                        new EFP(tickerId,tickType,basisPoints,formattedBasisPoints,impliedFuture,holdDays,futureExpiry,dividendImpact,dividendsToExpiry)
                ),
                this.EFPListeners
        );
    }

    public final class EFPEvent extends Event<EFP>{
        public EFPEvent(Object source, EFP data) { super(source, data); }
    }



    @Override
    public void error(Exception e)                            {
        this.processEvent(
                new ErrorEvent(this,
                        new com.tws.Error(e)
                ),
                this.errorListeners
        );
    }

    @Override
    public void error(String errorMessage)                    {
        this.processEvent(
                new ErrorEvent(this,
                        new com.tws.Error(errorMessage)
                ),
                this.errorListeners
        );
    }

    @Override
    public void error(int id, int errorCode, String errorMsg) {
        this.processEvent(
                new ErrorEvent(this,
                        new com.tws.Error(id, errorCode, errorMsg)
                ),
                this.errorListeners
        );
    }

    public final class ErrorEvent extends Event<com.tws.Error>{
        public ErrorEvent(Object source, Error data) { super(source, data); }
    }


    @Override
    public void connectionClosed() {
        this.processEvent(
                new ConnectionClosedEvent(this, new com.tws.ConnectionClosed()),
                this.connectionClosedListeners
        );
    }

    public final class ConnectionClosedEvent extends Event<com.tws.ConnectionClosed>{
        public ConnectionClosedEvent(Object source, com.tws.ConnectionClosed data) { super(source, data); }
    }


    @Override
    public void commissionReport(CommissionReport commissionReport) {
        this.processEvent(
                new CommissionReportEvent(this, commissionReport),
                this.commissionReportListeners
        );
    }

    public final class CommissionReportEvent extends Event<com.ib.client.CommissionReport>{
        public CommissionReportEvent(Object source, com.ib.client.CommissionReport data) { super(source, data); }
    }

    @Override
    public void marketRule(int marketRuleId, PriceIncrement[] priceIncrements) {
        this.processEvent(
                new MarketRuleEvent(this, Arrays.asList(priceIncrements)),
                this.marketRuleListeners
        );
    }

    public final class MarketRuleEvent extends Event<List<PriceIncrement>>{
        public MarketRuleEvent(Object source, List<PriceIncrement> data) { super(source, data); }
    }

    @Override
    public void headTimestamp(int reqId, String headTimestamp) {
        this.processEvent(
                new HeadTimestampEvent(this, new com.tws.HeadTimestamp(reqId,headTimestamp)),
                this.headTimestampListeners
        );
    }

    public final class HeadTimestampEvent extends Event<com.tws.HeadTimestamp>{
        public HeadTimestampEvent(Object source, com.tws.HeadTimestamp data) { super(source, data); }
    }


    @Override
    public void receiveFA(int faDataType, String xml) {
        this.processEvent(
                new FinancialAdvisoryEvent(this, new com.tws.FinancialAdvisory(faDataType,xml)),
                this.financialAdvisoryListeners
        );
    }

    public final class FinancialAdvisoryEvent extends Event<com.tws.FinancialAdvisory> {
        public FinancialAdvisoryEvent(Object source, com.tws.FinancialAdvisory data) {
            super(source, data);
        }

    }

    @Override
    public void fundamentalData(int reqId, String data) {
        this.processEvent(
                new FundamentalDataEvent(this, new com.tws.FundamentalData(reqId,data)),
                this.fundamentalDataListeners
        );
    }

    public final class FundamentalDataEvent extends Event<com.tws.FundamentalData>{
        public FundamentalDataEvent(Object source, com.tws.FundamentalData data) { super(source, data); }
    }


    @Override
    public void symbolSamples(int reqId, ContractDescription[] contractDescriptions) {

        // create new symbol sample event
        SymbolSampleEvent sse = new SymbolSampleEvent(this, reqId);

        // add contract descriptions to the data hashset
        sse.data.addAll(Arrays.asList(contractDescriptions));

        // setup done, process the event
        this.processEvent(sse,this.symbolSampleListeners);
    }

    public final class SymbolSampleEvent extends AggregateEvent<ContractDescription>{
        SymbolSampleEvent(Object obj, int reqId) { super(obj, reqId); }
    }



    @Override
    public void tickByTickAllLast(int reqId, int tickType, long time, double price, int size, TickAttr attribs, String exchange, String specialConditions) {

        this.processEvent(
                new TickByTickAllLastEvent(this,
                        new com.tws.TickByTickAllLast(
                            reqId,tickType,time,price,size,attribs,exchange,specialConditions
                        )
                ),
                this.tickByTickListeners
        );
    }

    @Override
    public void tickByTickBidAsk(int reqId, long time, double bidPrice, double askPrice, int bidSize, int askSize, TickAttr attribs) {
        this.processEvent(
                new TickByTickBidAskEvent(this,
                        new com.tws.TickByTickBidAsk(
                                reqId,time,bidPrice,askPrice,bidSize,askSize,attribs
                        )
                ),
                this.tickByTickListeners
        );
    }

    @Override
    public void tickByTickMidPoint(int reqId, long time, double midPoint) {
        this.processEvent(
                new TickByTickMidPointEvent(this,
                        new com.tws.TickByTickMidPoint(reqId,time,midPoint)
                ),
                this.tickByTickListeners
        );
    }

    public final class TickByTickAllLastEvent extends Event<com.tws.TickByTickAllLast>{
        public TickByTickAllLastEvent(Object source, com.tws.TickByTickAllLast data) { super(source, data); }
    }

    public final class TickByTickBidAskEvent extends Event<com.tws.TickByTickBidAsk>{
        public TickByTickBidAskEvent(Object source, com.tws.TickByTickBidAsk data) { super(source, data); }
    }

    public final class TickByTickMidPointEvent extends Event<com.tws.TickByTickMidPoint>{
        public TickByTickMidPointEvent(Object source, com.tws.TickByTickMidPoint data) { super(source, data); }
    }



}