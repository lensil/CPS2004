#include "shipment_service.grpc.pb.h"

class ShipmentPriceCalculatorImpl final : public com::cps2004::ShipmentService::Service {
    grpc::Status CalculateTotalPrice(grpc::ServerContext* context, 
                                     const com::cps2004::CalculateTotalPriceRequest* request,
                                     com::cps2004::CalculateTotalPriceResponse* response) override {
        double totalPrice = 0;
        totalPrice += request->shipment().transport().costperkm() * request->shipment().distance();
        for (int i = 0; i < request->shipment().packageditems_size(); i++) {
            const com::cps2004::Shipment shipment;
            totalPrice += (shipment.packageditems(i).product().price() * shipment.packageditems(i).quantity())
                    + shipment.packageditems(i).package().cost();
        }
        response->set_totalprice(totalPrice);
        return grpc::Status::OK;

    }
};
