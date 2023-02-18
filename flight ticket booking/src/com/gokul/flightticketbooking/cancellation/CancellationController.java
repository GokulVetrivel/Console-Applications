package com.gokul.flightticketbooking.cancellation;

public class CancellationController implements CancellationControllerModelCallBack, CancellationControllerViewCallBack {
	private CancellationViewCallBak cancellationView;
	private CancellationModelCallBack cancellationModel;
	
	public CancellationController(CancellationView cancellationView) {
		this.cancellationView=cancellationView;
		cancellationModel=new CancellationModel(this);
	}

	public boolean cancelBooking(int booking_id) {
		return cancellationModel.cancelBooking(booking_id);
	}

}
