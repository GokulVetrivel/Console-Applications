package com.gokul.flightticketbooking.cancellation;

import com.gokul.flightticketbooking.repository.BookingRepository;

public class CancellationModel implements CancellationModelCallBack {
	private CancellationControllerModelCallBack cancellationController;
	
	public CancellationModel(CancellationController cancellationController) {
		this.cancellationController=cancellationController;
	}

	public boolean cancelBooking(int booking_id) {
		return BookingRepository.getInstance().cancelBooking(booking_id);
	}

}
