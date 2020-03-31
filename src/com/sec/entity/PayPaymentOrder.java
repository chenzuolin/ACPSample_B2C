package com.sec.entity;



import java.math.BigDecimal;


/**
 * <p>
 *
 * </p>
 *
 * @author sipy
 * @since 2018-10-16
 */
public class PayPaymentOrder {
	
	private Long id;

    /**
     * 支付订单号
     */
    private String payOrderNo;

    /**
     * 商品交易订单号
     */
    private String payOutTradeNo;

    /**
     * 退款订单号UUID
     */
    private String payRefundNo;

    /**
     * 交易返回码
     */
    private String payCode;

    /**
     * 商品名称
     */
    private String paySubject;

    /**
     * 商户号
     */
    private String payMerNo;

    /**
     * 付款人
     */
    private Long payUserId;

    /**
     * 付款账号
     */
    private String payAccount;

    /**
     * 支付状态（01：待支付；02：支付成功；03：支付失败；04：待转账；05：转账完成；06：转账成功；07：待退款；08：退款完成；09退款失败）
     */
    private String payStatus;

    /**
     * 交易类型（01：收款；02：提现；03:退款）
     */
    private String payType;

    /**
     * 支付方式（01：支付宝；02：微信）
     */
    private String payMethod;

    /**
     * 渠道费率
     */
    private BigDecimal payChannelRate;

    /**
     * 渠道收费金额
     */
    private BigDecimal payChannelAmt;

    /**
     * 平台费率
     */
    private BigDecimal payPlatformRate;

    /**
     * 平台收费金额
     */
    private BigDecimal payPlatformAmt;

    /**
     * 真实交易金额
     */
    private BigDecimal payRealAmt;

    /**
     * 活动赠送费
     */
    private BigDecimal payGiveAmt;

    /**
     * 总金额
     */
    private BigDecimal payTotalAmt;

    /**
     * 订单创建时间
     */
    private String createTime;

    /**
     * 订单对账完成时间
     */
    private String completeTime;

    /**
     * 支付订单备注
     */
    private String remark;

    /**
     * 业务订单类型
     */
    private String orderType;

    private Long userId;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getPayOutTradeNo() {
		return payOutTradeNo;
	}

	public void setPayOutTradeNo(String payOutTradeNo) {
		this.payOutTradeNo = payOutTradeNo;
	}

	public String getPayRefundNo() {
		return payRefundNo;
	}

	public void setPayRefundNo(String payRefundNo) {
		this.payRefundNo = payRefundNo;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getPaySubject() {
		return paySubject;
	}

	public void setPaySubject(String paySubject) {
		this.paySubject = paySubject;
	}

	public String getPayMerNo() {
		return payMerNo;
	}

	public void setPayMerNo(String payMerNo) {
		this.payMerNo = payMerNo;
	}

	public Long getPayUserId() {
		return payUserId;
	}

	public void setPayUserId(Long payUserId) {
		this.payUserId = payUserId;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public BigDecimal getPayChannelRate() {
		return payChannelRate;
	}

	public void setPayChannelRate(BigDecimal payChannelRate) {
		this.payChannelRate = payChannelRate;
	}

	public BigDecimal getPayChannelAmt() {
		return payChannelAmt;
	}

	public void setPayChannelAmt(BigDecimal payChannelAmt) {
		this.payChannelAmt = payChannelAmt;
	}

	public BigDecimal getPayPlatformRate() {
		return payPlatformRate;
	}

	public void setPayPlatformRate(BigDecimal payPlatformRate) {
		this.payPlatformRate = payPlatformRate;
	}

	public BigDecimal getPayPlatformAmt() {
		return payPlatformAmt;
	}

	public void setPayPlatformAmt(BigDecimal payPlatformAmt) {
		this.payPlatformAmt = payPlatformAmt;
	}

	public BigDecimal getPayRealAmt() {
		return payRealAmt;
	}

	public void setPayRealAmt(BigDecimal payRealAmt) {
		this.payRealAmt = payRealAmt;
	}

	public BigDecimal getPayGiveAmt() {
		return payGiveAmt;
	}

	public void setPayGiveAmt(BigDecimal payGiveAmt) {
		this.payGiveAmt = payGiveAmt;
	}

	public BigDecimal getPayTotalAmt() {
		return payTotalAmt;
	}

	public void setPayTotalAmt(BigDecimal payTotalAmt) {
		this.payTotalAmt = payTotalAmt;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String time) {
		this.createTime = time;
	}

	
	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

    private static final long serialVersionUID = 1L;
}