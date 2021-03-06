package com.acmes.acmes.mode.request;

import com.acmes.acmes.AcmesAPI;
import com.acmes.acmes.mode.bean.BVideo;
import com.acmes.acmes.mode.response.AcmesResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by fishyu on 2018/2/27.
 */

public class SearchRequest extends AcmesRequest {

    public static final class Response extends AcmesResponse<List<BVideo>> {

    }


    @Override
    public Observable callAPI(AcmesAPI api) {
        return api.search(this);
    }
}
