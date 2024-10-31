# پیام رسان قزمیت :)
این یک برنامه خیلی کوچکی است که هر دوست عزیزی با هر سوادی (حتی سواد اول دبستان .. خخخ) می‌تواند بنویسد. ما قصد داریم این برنامه را به منظور یادگیری اصول شی گرایی به صورت عملی در اختیار دانشجویان عزیز و فرهیخته ای که در دانشکده مهندسی کامپیوتر و در بهار 1403 درس آز مهندسی نرم افزار را اخذ کرده اند قرار دهیم تا آن را اصلاح کنند.

# بخش دوم
<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۱</strong></p>
</td>
<td width="198">
<p>MessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>TelegramMessage</p>
</td>
<td width="141">
<p>افزودن کلاس مربوط به پیام های تلگرامی</p>
</td>
<td width="292">
<p>فزودن کلاس TelegramMessage و اضافه کردن متغیرهای آن و تعریف setter و getter برای آنها</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>EmailMessageService</p>
</td>
<td width="141">
<p>افزودن تابع sendTelegramMessage</p>
</td>
<td width="292">
<p>چون این کلاس، کلاس MessageService را implement میکند، باید تابع sendTelegramMessage در این کلاس نیز وجود داشته باشد.</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>SmsMessageService</p>
</td>
<td width="141">
<p>افزودن تابع sendTelegramMessage</p>
</td>
<td width="292">
<p>چون این کلاس، کلاس MessageService را implement میکند، باید تابع sendTelegramMessage در این کلاس نیز وجود داشته باشد.</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>پیاده سازی کلاس sendTelegramMessage</p>
</td>
<td width="292">
<p>افزودن و پیاده سازی توابع sendSmsMessage, sendEmailMessage, sendTelegramMessage, validatePhoneNumber</p>
</td>
</tr>

</tbody>
</table>

مجموع تعداد تغییرات: ۵

# بخش سوم
<table dir='rtl'>
    <tbody>
        <tr>
            <td rowspan="2" width="240">
                <p>اصل 1</p>
                <p>Single Responsibility</p>
            </td>
            <td width="95">
                <p><strong>موارد تحقق</strong></p>
            </td>
            <td width="454">
                <p>- ایجاد کلاس ContactValidator تنها برای اعتبارسنجی مخاطب و حذف این مسئولیت از کلاس Telegram. <br>
                    - اکنون Telegram تنها مسئول ارسال پیام است و عملکرد مستقلی دارد.
                    </p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>- اگر Telegram هم ارسال پیام و هم اعتبارسنجی را انجام دهد، نقض اصل SRP خواهد بود زیرا بیش از یک دلیل برای تغییر دارد.</p>
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <p>اصل 2</p>
                <p>Open-Close Principle (OCP)</p>
            </td>
            <td>
                <p><strong>موارد تحقق</strong></p>
            </td>
            <td>
                <p>- کلاس ContactValidator می‌تواند برای پشتیبانی از قواعد اعتبارسنجی جدید بدون تغییرات در کلاس فعلی توسعه یابد. <br>
                    - کلاس Telegram با استفاده از تزریق وابستگی قابلیت استفاده از اعتبارسنج‌های مختلف را دارد.</p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>- اگر تغییر در روش اعتبارسنجی یا ارسال پیام نیاز به تغییر در کلاس Telegram داشته باشد (بدون تزریق وابستگی) این اصل نقض می‌شود.</p>
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <p>اصل 3</p>
                <p>Liskov Substitution Principle</p>
            </td>
            <td>
                <p><strong>موارد تحقق</strong></p>
            </td>
            <td>
                <p>- کلاس‌های Telegram و هر کلاس دیگری که MessageService را پیاده‌سازی می‌کنند، بدون تغییر در رفتار پیش‌بینی‌شده قابل جایگزینی هستند.</p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>- اگر زیرکلاس MessageService نتواند انواع پیام‌های مورد انتظار را مدیریت کند، قرارداد کلاس والد را نقض کرده و اصل LSP را زیر پا می‌گذارد.</p>
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <p>اصل 4</p>
                <p>Interface Segregation Principle</p>
            </td>
            <td>
                <p><strong>موارد تحقق</strong></p>
            </td>
            <td>
                <p>- رابط MessageService فقط متد send_message را شامل می‌شود و نیاز به متدهای اضافی برای اعتبارسنجی یا مدیریت مخاطبین ندارد.</p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>- اگر MessageService متدهای اعتبارسنجی مخاطب را نیاز داشت، همه پیاده‌سازی‌ها مجبور به استفاده از متدهای غیرمرتبط می‌شدند و اصل ISP نقض می‌شد.</p>
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <p>اصل 5</p>
                <p>Dependency Inversion Principle</p>
            </td>
            <td>
                <p><strong>موارد تحقق</strong></p>
            </td>
            <td>
                <p><rtl>- تلگرام با تکیه بر رابط ContactValidator وابسته به یک پیاده‌سازی خاص نیست و ماژول‌های سطح بالا می‌توانند بدون وابستگی مستقیم از ماژول‌های سطح پایین استفاده کنند.</rtl></p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>- اگر Telegram مستقیماً یک پیاده‌سازی خاص از ContactValidator را ایجاد کرده یا به آن وابسته باشد، اصل DIP نقض شده و وابستگی مستقیم ایجاد می‌شود.</p>
            </td>
        </tr>
    </tbody>
</table>

# بخش چهارم
<table dir='rtl'>
    <tbody>
        <tr>
            <td width="168">
                <p><strong>اصل مربوطه (از اصول <strong>SOLID</strong>)</strong></p>
            </td>
            <td width="246">
                <p><strong>علت نقض</strong></p>
            </td>
            <td width="284">
                <p><strong>راه حل پیشنهادی</strong></p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>مسئولیت واحد (SRP)</p>
            </td>
            <td width="246">
                <p>کلاس <code>Telegram</code> علاوه بر ارسال پیام، مسئولیت اعتبارسنجی مخاطب را نیز بر عهده داشت.</p>
            </td>
            <td width="284">
                <p>تفکیک وظایف با ایجاد کلاس <code>ContactValidator</code> که تنها برای اعتبارسنجی مخاطب استفاده می‌شود،
                    به طوری که <code>Telegram</code> تنها ارسال پیام را انجام دهد.</p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>باز-بسته (OCP)</p>
            </td>
            <td width="246">
                <p>اگر بخواهیم روش‌های جدید اعتبارسنجی یا ارسال پیام را اضافه کنیم، نیاز به تغییر در کد کلاس
                    <code>Telegram</code> خواهیم داشت.</p>
            </td>
            <td width="284">
                <p>استفاده از <em>تزریق وابستگی</em> و تعریف رابط‌های جداگانه برای انواع اعتبارسنجی و پیام‌رسانی، که
                    امکان گسترش کد بدون تغییر در کلاس‌های موجود را فراهم کند.</p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>جایگزینی لیسکوف (LSP)</p>
            </td>
            <td width="246">
                <p>پیاده‌سازی‌هایی از <code>MessageService</code> که نتوانند همه انواع پیام را مدیریت کنند، می‌توانند
                    اصل LSP را نقض کنند.</p>
            </td>
            <td width="284">
                <p>تعریف دقیق‌تر <code>MessageService</code> و محدود کردن پیام‌هایی که انتظار می‌رود زیرکلاس‌ها مدیریت
                    کنند، یا ایجاد رابط‌های مختلف برای انواع خاص پیام‌ها.</p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>تفکیک رابط‌ها (ISP)</p>
            </td>
            <td width="246">
                <p>در صورتی که <code>MessageService</code> شامل متدهای اضافی برای اعتبارسنجی یا مدیریت مخاطبین بود، اصل
                    ISP نقض می‌شد.</p>
            </td>
            <td width="284">
                <p>تعریف رابط‌های جداگانه مانند <code>ValidatorService</code> و <code>MessageService</code>، تا هر کلاسی
                    تنها از رابط‌های مرتبط با وظایف خود استفاده کند.</p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>وارونگی وابستگی (DIP)</p>
            </td>
            <td width="246">
                <p>کلاس <code>Telegram</code> به پیاده‌سازی خاصی از <code>ContactValidator</code> وابسته است، که باعث
                    نقض DIP می‌شود.</p>
            </td>
            <td width="284">
                <p>استفاده از رابط‌ به جای وابستگی به پیاده‌سازی خاص، و تزریق وابستگی برای استفاده از هر اعتبارسنجی که
                    از <code>ValidatorService</code> پیروی می‌کند.</p>
            </td>
        </tr>
    </tbody>
</table>

این جدول راهکارهای پیشنهادی برای هر یک از اصول نقض شده را در راستای تحقق اصول SOLID ارائه می‌دهد.
