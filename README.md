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
مطابق توضیحات ارائه شده در شرح آزمایش، از توضیح موارد تحقق و نقض اصل SRP صرف نظر شده است.
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
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
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
                 <p>-
                    به علت عدم پیاده‌سازی متدهای validation در رابط، با اضافه شدن کلاس‌های جدید نیاز به تغییر این بخش از کلاس‌های قبلی نیست و این اصل به این علت نقض نمی‌شود.
                    <br></p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>- از آن‌جا که کلاس‌های messageService از یک interface واحد ارث‌بری می‌کنند که برای هر نوع سرویس پیام در آن یک تابع جدا معرفی شده، همانطور که در بخش قبل دیدیم برای اضافه کردن یک کلاس جدید باید کلاس‌های message Service دیگر هم تغییر پیدا می‌کردند تا تابع ارسال پیام این کلاس جدید به آن‌ها اضافه شود.</p>
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
                <p>-تمام توابع interface MessageService در  کلاس‌های فرزند وجود دارند.</p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>-در هر سه کلاس EmailMessageService, TelegramMessageService, SMSMessageService توابع وجود دارند اما پیاده‌سازی‌ها به‌طور کامل وجود ندارند به همین دلیل این کلاس‌ها قابلیت جایگزینی با کلاس پدر را ندارند.</p>
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
                <p>- رابط MessageService متدهای مربوط به اعتبارسنجی مخاطب را پیاده‌سازی نکرده و از این رو، پیاده‌سازی‌ها مجبور به استفاده از متدهای غیرمرتبط به ماهیت خود نیستند.</p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                - رابط هیچ متدی برای اعتبارسنجی مخاطبان پیاده‌سازی نکرده و از این رو، انسجام پیاده‌سازی برای کلاس‌های فرزند قابل اعمال نیست. این به این خاطر است که رابط از سطح انتزاع مناسبی در مورد این موضوع برخوردار نیست.
                    <br>
برخلاف توضیح بالا در رابطه با اعتبارسنجی مخاطبین، متدهای مربوط به ارسال پیام در رابط پیاده‌سازی شده‌اند و از این رو، کلاس‌های فرزند مجبور به پیاده‌سازی توابع با بدنه خالی شده ‌اند و Refused Bequest رخ داده است.</p>
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
                <p>
                    توابع زیرکلاس، وابستگی‌ای به رابط برای پیاده‌سازی اعتبارسنجی مخاطب ندارند و تغییر در آن‌ها باعث تغییر بخش‌های دیگر سیستم‌ نخواهد بود.
                </p>
            </td>
        </tr>
        <tr>
            <td>
                <p><strong>موارد نقض</strong></p>
            </td>
            <td>
                <p>
- به علت وجود متدهای ارسال هر یک از انواع پیام در سطح interface، از سطح انتزاع مطلوب در رابطه با این توابع برخوردار نیستیم و رابط بیش از حد به جزئیات دسترسی دارد. از این رو، کلاس‌های concrete مجبور به پیاده‌سازی توابع ارسال دیگر کلاس‌ها می‌شوند.
                </p>
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
                <p>باز-بسته (OCP)</p>
            </td>
            <td width="246">
                <p>وجود توابع sendEmailMessage, sendTelegramMessage, sendSMSMessage در کلاس MessageService</p>
            </td>
            <td width="284">
                <p>به‌جای اینکه در کلاس MessageService برای هر نوع پیام یک تابع داشته باشیم می‌توان یک تابع ارسال پیام داشت که ورودی آن Message باشد نه EmailMessage, TelegramMessage یا SMSMessage</p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>جایگزینی لیسکوف (LSP)</p>
            </td>
            <td width="246">
                <p>در کلاس‌های فرزند MessageService توابعی وجود دارد که بدنه آن‌ها پیاده‌سازی نشده است بنابراین قابلیت جایگزینی ندارد.</p>
            </td>
            <td width="284">
                <p>به‌جای تعریف یک تابع برای ارسال هر یک از پیام‌های SMS, Email و Telegram می‌توان یک تابع sendMessage به‌طور جامع پیاده‌سازی کرد.</p>
            </td>
        </tr>
        <tr>
            <td width="168">
                <p>تفکیک رابط‌ها (ISP)</p>
            </td>
            <td width="246">
                <p>در کلاس MessageService برای ارسال هریک از پیام‌های ایمیل، اس ام اس و تلگرام یک تابع وجود دارد که باعث ایجاد توابع خالی در کلاس‌های فرزند MessageService شده است.</p>
            </td>
            <td width="284">
                <p>به‌جای تعریف یک تابع برای ارسال هر یک از پیام‌های SMS, Email و Telegram می‌توان یک تابع sendMessage به‌طور جامع پیاده‌سازی کرد.</p>
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
