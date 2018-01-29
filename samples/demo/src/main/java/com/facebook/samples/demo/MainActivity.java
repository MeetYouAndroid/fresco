/*
 * This file provided by Facebook is for non-commercial testing and evaluation
 * purposes only.  Facebook reserves all rights not expressly granted.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * FACEBOOK BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.samples.demo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewAndLoadUri(R.id.baseline_jpeg, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3975589162,1369053045&fm=116&gp=0.jpg");

    ImageRequest request = ImageRequestBuilder.newBuilderWithSource(
            Uri.parse("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3975589162,1369053045&fm=116&gp=0.jpg"))
            .setProgressiveRenderingEnabled(true)
            .build();
    findViewAndLoadAnimatedImageUri(
            R.id.animated_gif,
            "http://sc.seeyouyima.com/assess/20180126/5a6a8877a98f8_768_432.gif?imageView2/1/w/750/h/500/format/webp");

    findViewById(R.id.baseline_jpeg).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        new Thread(new Runnable() {
//          @Override
//          public void run() {
//            ImagePipeline imagePipeline = Fresco.getImagePipeline();
//            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(
//                    Uri.parse("http://pic.duowan.com/newgame/1109/179919961792/179920848656.jpg"))
//                    .setSync(true)
//                    .build();
//            try {
//              Bitmap bitmap = imagePipeline.fetchBitmap(request, this);
//              int i;
//              i = 10;
//            } catch (Exception e) {
//              e.printStackTrace();
//            }
//          }
//        }).start();

//        ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(
//                Uri.parse("http://img7.ptpcp.com/v2/thumb/jpg/NTkxYywwLDAsNCwzLDEsLTEsMSw=/u/www.ptbus.com/uploads/allimg/1312/12/1483-131212114031.jpg"))
//                .setSync(true)
//                .build();
//        DataSource<CloseableReference<CloseableImage>>
//                dataSource1 = imagePipeline.fetchDecodedImage(request, this);
//        ImageRequest request2 = ImageRequestBuilder.newBuilderWithSource(
//                Uri.parse("http://s.doyo.cn/img/50/79/02c09e9e788369003eff.jpg"))
//                .setSync(true)
//                .build();
//        DataSource<CloseableReference<CloseableImage>>
//                dataSource2 = imagePipeline.fetchDecodedImage(request, this);
//        ImageRequest request3 = ImageRequestBuilder.newBuilderWithSource(
//                Uri.parse("http://img5.imgtn.bdimg.com/it/u=2170541376,3396146853&fm=21&gp=0.jpg"))
//                .setSync(true)
//                .build();
//        DataSource<CloseableReference<CloseableImage>>
//                dataSource3 = imagePipeline.fetchDecodedImage(request, this);
//        ImageRequest request4 = ImageRequestBuilder.newBuilderWithSource(
//                Uri.parse("http://images.forwallpaper.com/files/images/6/6237/6237eaaa/410731/night-elf-druid.jpg"))
//                .setSync(true)
//                .build();
//        DataSource<CloseableReference<CloseableImage>>
//                dataSource4 = imagePipeline.fetchDecodedImage(request, this);

      }
    });


    DraweeController controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(request)
            .build();
    findViewAndSetController(R.id.progressive_jpeg, controller);

//    findViewAndLoadUri(R.id.static_webp, "https://www.gstatic.com/webp/gallery/2.sm.webp");
//
//    findViewAndLoadUri(R.id.alpha_webp, "http://frescolib.org/static/translucent.webp")
//            .getHierarchy().setBackgroundImage(new ColorDrawable(0xFF302013));
//
//    findViewAndLoadAnimatedImageUri(
//            R.id.animated_gif,
//            "https://s3.amazonaws.com/giphygifs/media/4aBQ9oNjgEQ2k/giphy.gif");
//
//    findViewAndLoadAnimatedImageUri(
//            R.id.animated_webp,
//            "https://www.gstatic.com/webp/animated/1.webp");
//
//    findViewAndLoadAnimatedImageUri(
//            R.id.one_loop_animated_webp,
//            "https://dl.dropboxusercontent.com/u/6610969/webp_180_example.webp");
//
//    String dataUri = "data:image/webp;base64," +
//            "UklGRjgCAABXRUJQVlA4WAoAAAAQAAAAFwAAFwAAQUxQSC0AAAABJ6AgbQNm1+EkTnRExDkWahpJgRIk" +
//            "oOCVgAKy/mVdSxvR/wyEHWJ49xCbCAcAVlA4IOQBAACQCgCdASoYABgAPlEkjkWjoiEUBAA4BQS2AE6Z" +
//            "Qjgbyv8ZuWF3B3ANsBdoHoAeWj+s3wleTHcua7PMAYrNOLPHFqAbpKGWe8x3KqHen7YXTMnmq/c9GqBt" +
//            "ZtuQ0AAA/r031iZbkliICmd/QSg0OjEWbX/nv8v+g4UDPpobcehywI6oypX8hbuzcQndgaVt0zW5DiZP" +
//            "6Ueo/21IPqsuRm1WyZHL3bJIFStwH8BOWif7xVniUiHwD5HwW8AXIZiq2maDmyIvxn4a0fetR+flTrt/" +
//            "5/Vq3BVTeorYBHMN7L09DE9xDW/2+dj45/mCe9vjNUGRpT5EJhV8jDz/ZxPixLvN9Tl5iPD/neh1RCl6" +
//            "AOcx3JudnAseXqvm8dEtF+rA40Bg881EW88XwU1oXf/5RY/4ToF9NwcXPLC/AodLaAFPpiXt+C6cFDIj" +
//            "+uqi12PWFO+p7jn1P+sjCpbP/OBdHIoez8Rp6nslBEiFG19LKqv6dkGzLKtvt9dRIpz2sef2JFUVB+v+" +
//            "hvMMmQ4o6d8aMTGuv/4wZxogl/n/k3g83NO3bBnf7/TL8Baf97pQw43+FVR0hXfpvD0k51yE35e2jNF/" +
//            "98Uv3fAfPXw0T8irZQR4r1/ktG5xrypg/aKDooBtoI5aQAAA";
//    findViewAndLoadUri(R.id.data_webp, dataUri);
  }

  private SimpleDraweeView findAndPrepare(@IdRes int viewId) {
    SimpleDraweeView view = (SimpleDraweeView) findViewById(viewId);
    view.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
    return view;
  }

  private SimpleDraweeView findViewAndLoadUri(@IdRes int viewId, String uri) {
    SimpleDraweeView view = findAndPrepare(viewId);
    view.setImageURI(Uri.parse(uri));
    return view;
  }

  private SimpleDraweeView findViewAndSetController(
          @IdRes int viewId,
          DraweeController controller) {
    SimpleDraweeView view = findAndPrepare(viewId);
    view.setController(controller);
    return view;
  }

  private SimpleDraweeView findViewAndLoadAnimatedImageUri(@IdRes int viewId, String uri) {
    DraweeController animatedController = Fresco.newDraweeControllerBuilder()
            .setAutoPlayAnimations(true)
            .setUri(Uri.parse(uri))
            .build();
    return findViewAndSetController(viewId, animatedController);
  }
}
