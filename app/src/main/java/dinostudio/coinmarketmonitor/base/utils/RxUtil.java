package dinostudio.coinmarketmonitor.base.utils;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public class RxUtil {


    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    DLogUtils.d("TTTT: " + t);
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

//    public static <T> FlowableTransformer<BtsResponse<T>, T> handleResult() {   //compose判断结果
//        return new FlowableTransformer<BtsResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<BtsResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<BtsResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(BtsResponse<T> tGankHttpResponse) {
//                        if (tGankHttpResponse.getCode() == 200) {
//                            DLogUtils.d("BtsResponse" + tGankHttpResponse.toString());
//                            return createData(tGankHttpResponse.getData());
//                        } else {
//                            return Flowable.error(new ApiException("服务器返回error"));
//                        }
//                    }
//                });
//            }
//        };
//    }
}
