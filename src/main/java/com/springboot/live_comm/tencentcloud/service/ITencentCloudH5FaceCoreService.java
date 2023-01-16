package com.springboot.live_comm.tencentcloud.service;


import com.springboot.live_comm.tencentcloud.dto.*;

public interface ITencentCloudH5FaceCoreService {
    /**
     * @param sendIdentityInformationRequestDto
     * @return
     */
    TencentCloudSendIdentityInformationResponseDto sendIdentityInformation(TencentCloudSendIdentityInformationRequestDto sendIdentityInformationRequestDto);

    /**
     * @param startH5FaceCoreRequestDto
     * @return
     */
    String startH5FaceCore(TencentCloudStartH5FaceCoreRequestDto startH5FaceCoreRequestDto);

    /**
     * @param getAccessTokenRequestDto
     * @return
     */
    TencentCloudGetAccessTokenResponseDto getAccessToken(TencentCloudGetAccessTokenRequestDto getAccessTokenRequestDto);

    /**
     * @param getSignTicketRequestDto
     * @return
     */
    TencentCloudGetSignTicketResponseDto getSignTicket(TencentCloudGetSignTicketRequestDto getSignTicketRequestDto);

    /**
     * @param getNonceTicketRequestDto
     * @return
     */
    TencentCloudGetNonceTicketResponseDto getNonceTicket(TencentCloudGetNonceTicketRequestDto getNonceTicketRequestDto);

    /**
     * @param getTencentH5CoreResultRequestDto
     * @return
     */
    GetTencentH5CoreResultResponsetDto getH5FaceCoreResult(GetTencentH5CoreResultRequestDto getTencentH5CoreResultRequestDto);
}
