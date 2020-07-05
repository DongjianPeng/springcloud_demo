package top.murphypen.springcloud.mapper.base;

import java.util.List;

import model.Payment;
/**
*  @author pdj
*/
public interface PaymentBaseMapper {

    int insertPayment(Payment object);

    int updatePayment(Payment object);

    int update(Payment.UpdateBuilder object);

    List<Payment> queryPayment(Payment object);

    Payment queryPaymentLimit1(Payment object);

}